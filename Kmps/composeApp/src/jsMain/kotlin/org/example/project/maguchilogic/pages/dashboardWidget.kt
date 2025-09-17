package org.example.project.maguchilogic.pages



import GreetingHeader
import ShimmerBox
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import org.example.project.AppStylesheet.hover
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.generateCSV.downloadCSV
import org.example.project.maguchilogic.pages.generateCSV.generatePDF
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun DashboardMainContent(warehouseItems: List<WarehouseItem>, isLoading: Boolean) {
    H2 { GreetingHeader() }
    P { Text("Select an option from the sidebar to get started.") }

    // Cards Section
    Div({
        style {
            display(DisplayStyle.Flex)
            gap(24.px)
            flexWrap(FlexWrap.Wrap)
            marginTop(24.px)
        }
    }) {
        if (isLoading) {
            repeat(3) {
                ShimmerBox(width = 200.px, height = 120.px) { borderRadius(8.px) }
            }
        } else {
            val items = warehouseItems
            val totalItems = items.sumOf { it.quantity }
            val lowStock = items.count { it.quantity <= 10 }
            val expiredItems = items.count { it.expiryDate.isNotEmpty() && isExpired(it.expiryDate) }

            StockCard(title = "Total Items", count = totalItems)
            StockCard(title = "Low Stock", count = lowStock)
            StockCard(title = "Expired Items", count = expiredItems)
        }
    }

    // Export Buttons (show only after loading)
    if (!isLoading) {
        Div({
            style {
                marginTop(32.px)
                display(DisplayStyle.Flex)
                gap(8.px)
            }
        }) {
            val items = warehouseItems
            Button({ onClick { downloadCSV(items) }; style { padding(8.px,16.px); borderRadius(6.px); property("border","none"); backgroundColor(rgb(60,130,200)); color(Color.white); cursor("pointer") } }) { Text("Export CSV") }
            Button({ onClick { generatePDF(items) }; style { padding(8.px,16.px); borderRadius(6.px); property("border","none"); backgroundColor(rgb(40,180,70)); color(Color.white); cursor("pointer") } }) { Text("Export PDF") }
        }
    }

    // Bar Graph Section
    Div({
        style {
            marginTop(32.px)
            property("width", "100%")

            padding(16.px)
            backgroundColor(rgb(255,255,255))
            borderRadius(8.px)
            property("box-shadow","0px 2px 6px rgba(0,0,0,0.1)")
        }
    }) {
        H3 { Text("Stock Levels") }
        if (isLoading) {
            ShimmerBox(width = 0.px, height = 250.px) {
                borderRadius(8.px)
                property("width", "100%") // use CSS percentage
            }


        } else {
            val topItems = warehouseItems.sortedByDescending { it.quantity }.take(5)
            SimpleBarGraph(labels = topItems.map { it.name }, values = topItems.map { it.quantity })
        }
    }
}




@Composable
fun StockCard(title: String, count: Int) {
    Div({ classes(AppStylesheet.stockCard) }) {
        Span({ classes(AppStylesheet.stockTitle) }) { Text(title) }
        H2({ classes(AppStylesheet.stockCount) }) { Text(count.toString()) }
    }
}

@Composable
fun SimpleBarGraph(labels: List<String>, values: List<Int>) {
    val maxValue = values.maxOrNull() ?: 1

    // Pick different colors for bars
    val barColors = listOf(
        rgb(70, 130, 180), // Steel Blue
        rgb(60, 179, 113), // Medium Sea Green
        rgb(255, 165, 0),  // Orange
        rgb(220, 20, 60),  // Crimson
        rgb(123, 104, 238) // Medium Slate Blue
    )

    Div({ classes(AppStylesheet.barContainer) }) {
        labels.forEachIndexed { index, label ->
            val value = values[index]
            val heightPx = (value.toDouble() / maxValue.toDouble() * 150).px

            Div({ classes(AppStylesheet.barItem) }) {
                // Bar
                Div({
                    classes(AppStylesheet.bar)
                    style {
                        property("transition", "height 0.8s ease, background-color 0.8s ease")
                        height(heightPx)
                        backgroundColor(barColors[index % barColors.size])
                    }
                }) {}

                // Value label on top of bar
                Span({
                    style {
                        display(DisplayStyle.Block)
                        textAlign("center")
                        fontSize(12.px)
                        fontWeight("bold")
                        marginBottom(4.px)
                    }
                }) {
                    Text(value.toString())
                }

                // X-axis label under bar
                Span({ classes(AppStylesheet.barLabel) }) {
                    Text(label)
                }
            }
        }
    }
}


// Helper to check if expiryDate is past


