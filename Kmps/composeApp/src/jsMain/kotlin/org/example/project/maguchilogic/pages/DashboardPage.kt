package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.project.AppStylesheet.hover
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.appstylesheetlogic.WarehousePage
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.*

@Composable
fun DashboardPage(
    warehouseItems: List<WarehouseItem>,
    onNavigateInventory: () -> Unit,
    onNavigateWarehouse: () -> Unit,
    onNavigateReports: () -> Unit,
    onNavigateSettings: () -> Unit,
    onLogout: () -> Unit
) {
    Style(AppStylesheet)

    var currentSection by remember { mutableStateOf("dashboard") }

    Div({
        style {
            display(DisplayStyle.Flex)
            width(100.percent)
            height(100.vh)
            minHeight(500.px)
        }
    }) {
        // Sidebar
        Div({
            style {
                width(200.px)
                backgroundColor(rgb(45, 45, 45))
                color(Color.white)
                padding(16.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
            }
        }) {
            // App Icon
            Div({
                style {
                    display(DisplayStyle.Flex)
                    justifyContent(JustifyContent.Center)
                    marginBottom(12.px) // reduce space
                }
            }) {
                Img(src = "images/appicon.png", attrs = {
                    classes(AppStylesheet.appIcon)

                })
            }

            // Menu
            val menuItems = listOf(
                "dashboard" to "Dashboard",
                "warehouse" to "Warehouse",
                "reports" to "Reports",
                "settings" to "Settings"
            )

            menuItems.forEach { (section, label) ->
                Div({
                    classes(AppStylesheet.sidebarItem)
                    if (currentSection == section) classes(AppStylesheet.sidebarItemSelected)
                    onClick { currentSection = section }
                    style {
                        padding(8.px, 12.px)
                        cursor("pointer")
                        borderRadius(6.px)
                        marginBottom(8.px)
                    }
                }) { Text(label) }
            }

            // Logout button
            Button({
                onClick { onLogout() }
                style {
                    marginTop(24.px)
                    backgroundColor(rgb(200, 50, 50))
                    color(Color.white)
                    property("border", "none")
                    padding(8.px, 16.px)
                    borderRadius(6.px)
                    cursor("pointer")
                    width(100.percent)
                }
            }) { Text("Logout") }
        }

        // Main content
        Div({
            style {
                property("flex", "1.0")
                padding(24.px)
                overflowY("auto")
                backgroundColor(rgb(245, 245, 245))
                minHeight(100.percent)
                property("transition", "all 0.3s ease")
            }
        }) {
            AnimatedSection(
                currentSection,
                warehouseItems = warehouseItems,
                onBackWarehouse = { currentSection = "dashboard" },
                onBackReports = { currentSection = "dashboard" },
                onBackSettings = { currentSection = "dashboard" }
            )
        }
    }
}

@Composable
fun AnimatedSection(
    section: String,
    warehouseItems: List<WarehouseItem>,
    onBackWarehouse: () -> Unit,
    onBackReports: () -> Unit,
    onBackSettings: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    var isDashboardLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(1000) // simulate data fetching
        isDashboardLoading = false
    }


    LaunchedEffect(section, warehouseItems.size) {
        visible = false
        delay(50)
        visible = true
    }

    Div({
        style {
            opacity(if (visible) 1.0 else 0.0)
            property("transition", "all 0.3s ease")
        }
    }) {
        when (section) {
            "dashboard" -> DashboardMainContent(
                warehouseItems,
                isLoading =isDashboardLoading
            )
            "warehouse" -> WarehousePage(onBack = onBackWarehouse, )
            "reports" -> ReportsPage(onBack = onBackReports,)
            "settings" -> SettingsPage(onLogout = onBackSettings, onBack = onBackSettings)
        }
    }
}
