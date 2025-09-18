package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import kotlinx.browser.window
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
    onNavigateDashboard: () -> Unit,

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
                backgroundColor(rgba(45, 45, 45, 0.85))
                property("backdrop-filter", "blur(8px) saturate(150%)")
                property("-webkit-backdrop-filter", "blur(8px) saturate(150%)")
                borderRadius(12.px)
                border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
                property("box-shadow", "0 4px 16px rgba(0, 0, 0, 0.2)")
                color(Color.white)
                padding(16.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Stretch)
                gap(12.px)
            }

        }) {
            // App Icon
            Div({
                style {
                    display(DisplayStyle.Flex)
                    justifyContent(JustifyContent.Center)
                    marginBottom(12.px)
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
                    classes(AppStylesheet.menuButton)
                    if (currentSection == section) classes(AppStylesheet.menuButtonSelected)

                    onClick {
                        currentSection = section

                        // Update AppPage + URL
                        when (section) {
                            "dashboard" -> { /* do nothing, already dashboard */ }
                            "warehouse" -> onNavigateWarehouse()
                            "reports" -> onNavigateReports()
                            "settings" -> onNavigateSettings()
                        }
                    }

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
                onBackWarehouse = {
                    currentSection = "dashboard"
                    onNavigateDashboard()
                },
                onBackReports = {
                    currentSection = "dashboard"
                    onNavigateDashboard()
                },
                onBackSettings = {
                    currentSection = "dashboard"
                    onNavigateDashboard()
                },
                onNavigateDashboard = onNavigateDashboard // <- pass it here
            )


        }
    }
}


@Composable
fun AnimatedSection(
    initialSection: String,
    warehouseItems: List<WarehouseItem>,
    onBackWarehouse: () -> Unit,
    onBackReports: () -> Unit,
    onBackSettings: () -> Unit,
    onNavigateDashboard: () -> Unit
) {
    var currentSection by remember { mutableStateOf(initialSection) }

    var visible by remember { mutableStateOf(false) }
    var isDashboardLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(1000) // simulate data fetching
        isDashboardLoading = false
    }

    LaunchedEffect(currentSection, warehouseItems.size) {
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
        when (currentSection) {
            "dashboard" -> DashboardMainContent(
                warehouseItems,
                isLoading = isDashboardLoading
            )
            "warehouse" -> WarehousePage(
                onBack = {
                    currentSection = "dashboard"
                    onNavigateDashboard() // navigate + update URL
                }
            )
            "reports" -> ReportsPage(
                onBack = {
                    currentSection = "dashboard"
                    onNavigateDashboard()
                },
                warehouseItems =warehouseItems
            )
            "settings" -> SettingsPage(
                onBack = {
                    currentSection = "dashboard"
                    onNavigateDashboard()
                },
                onLogout = { window.location.replace(pageToUrl(AppPage.LOGIN)) }
            )
        }
    }
}
