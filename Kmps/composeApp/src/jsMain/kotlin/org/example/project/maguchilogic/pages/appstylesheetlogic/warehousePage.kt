package org.example.project.maguchilogic.pages.appstylesheetlogic


import BackButton
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.example.project.maguchilogic.pages.getLoggedInState
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun WarehousePage(onBack: () -> Unit) {
    Style(AppStylesheet)

    val items = remember { mutableStateListOf<WarehouseItem>() }

    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    // Load items
    LaunchedEffect(Unit) {
        val fetchedItems = WarehouseApi.getItems()
        items.clear()
        items.addAll(fetchedItems)
    }

    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            width(100.percent)
            minHeight(600.px)
            padding(24.px)
            gap(24.px)
            backgroundColor(rgba(245, 245, 250, 1)) // light modern background
        }
    }) {

        // Header
        Div({
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
                marginBottom(24.px)
            }
        }) {
            BackButton { onBack() }


            H2({
                style {
                    textAlign("center")
                    property("flex", "1.0")
                    color(Color("#2E8B57"))
                }
            }) { Text("Warehouse Page") }

            Div { } // empty space to balance flex
        }

        // Add Item Form
        Div({
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(12.px)
                backgroundColor(Color.white)
                padding(16.px)
                borderRadius(12.px)
                property("box-shadow", "0px 4px 8px rgba(0,0,0,0.05)")
            }
        }) {
            Input(InputType.Text, attrs = {
                placeholder("Item Name")
                value(name)
                onInput { name = it.value }
                style { width(180.px); padding(10.px); borderRadius(6.px); property("border", "1px solid #ccc") }
            })

            Input(InputType.Number, attrs = {
                placeholder("Quantity")
                value(quantity)
                onInput { quantity = it.value.toString() }
                style { width(120.px); padding(10.px); borderRadius(6.px); property("border", "1px solid #ccc") }
            })

            Input(InputType.Date, attrs = {
                value(date)
                onInput { date = it.value }
                style { width(160.px); padding(10.px); borderRadius(6.px); property("border", "1px solid #ccc") }
            })

            Input(InputType.Text, attrs = {
                placeholder("Location")
                value(location)
                onInput { location = it.value }
                style { width(160.px); padding(10.px); borderRadius(6.px); property("border", "1px solid #ccc") }
            })

            Button({
                onClick {
                    if (name.isNotEmpty() && quantity.isNotEmpty()) {
                        val newItem = WarehouseItem(
                            id = (items.maxOfOrNull { it.id } ?: 0) + 1,
                            name = name,
                            quantity = quantity.toIntOrNull() ?: 0,
                            expiryDate = date,
                            location = location
                        )
                        scope.launch {
                            WarehouseApi.addItem(newItem)
                            items.add(newItem)
                        }
                        name = ""
                        quantity = ""
                        location = ""
                        date = ""
                    }
                }
                style {
                    backgroundColor(rgb(33, 150, 243))
                    color(Color.white)
                    borderRadius(8.px)
                    padding(10.px, 20.px)
                    cursor("pointer")
                    property("border", "none")
                    property("box-shadow", "0px 2px 4px rgba(0,0,0,0.1)")
                }
            }) { Text("Add Item") }
        }

        // Item List Table
        Div({
            style {
                width(100.percent)
                overflowX("auto")
                borderRadius(12.px)
                property("box-shadow", "0px 4px 6px rgba(0,0,0,0.05)")
                backgroundColor(Color.white)
            }
        }) {
            Table({
                style {
                    width(100.percent)
                    property("border-collapse", "collapse")
                    minWidth(600.px)
                }
            }) {
                // Table Header
                Thead {
                    Tr({
                        style {
                            backgroundColor(rgb(33, 150, 243))
                            color(Color.white)
                            textAlign("left")
                            height(48.px)
                        }
                    }) {
                        listOf("ID", "Name", "Quantity", "Expiry Date", "Location", "Actions").forEach { header ->
                            Th({
                                style {
                                    padding(12.px, 16.px)
                                }
                            }) { Text(header) }
                        }
                    }
                }

                // Table Body
                Tbody {
                    items.forEach { item ->
                        Tr({
                            style {
                                property("transition", "background-color 0.2s ease")
                                property(
                                    ":hover",
                                    "background-color: rgba(230,230,250,0.5)"
                                )
                            }
                        }) {
                            Td({ style { padding(12.px, 16.px) } }) { Text("#${item.id}") }
                            Td({ style { padding(12.px, 16.px) } }) { Text(item.name) }
                            Td({ style { padding(12.px, 16.px) } }) { Text(item.quantity.toString()) }
                            Td({ style { padding(12.px, 16.px) } }) { Text(item.expiryDate) }
                            Td({ style { padding(12.px, 16.px) } }) { Text(item.location) }

                            Td({ style { padding(12.px, 16.px) } }) {
                                Button({
                                    onClick {
                                        scope.launch {
                                            WarehouseApi.deleteItem(item.id)
                                            items.remove(item)
                                        }
                                    }
                                    style {
                                        backgroundColor(rgb(200, 50, 50))
                                        color(Color.white)
                                        borderRadius(6.px)
                                        padding(6.px, 16.px)
                                        cursor("pointer")
                                        property("border", "none")
                                        property("box-shadow", "0px 2px 4px rgba(0,0,0,0.1)")
                                    }
                                }) { Text("Delete") }
                            }
                        }
                    }
                }
            }
        }

    }
}


