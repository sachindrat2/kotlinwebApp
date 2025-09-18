//package org.example.project.maguchilogic.pages
//
//import AppFooter
//import androidx.compose.runtime.*
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
//import org.example.project.maguchilogic.pages.appstylesheetlogic.WarehousePage
//import org.example.project.maguchilogic.pages.model.WarehouseApi
//import org.example.project.maguchilogic.pages.model.WarehouseItem
//import org.jetbrains.compose.web.css.Style
//import org.jetbrains.compose.web.dom.*
//
//enum class AppPage {
//    LOGIN, DASHBOARD, INVENTORY, ADD_ITEM, WAREHOUSE, REPORTS, SETTINGS
//}
//
//
//
//@Composable
//fun MaguchiLogicApp() {
//    Style {
//        """
//    @keyframes shimmer {
//        0% { background-position: -200% 0; }
//        100% { background-position: 200% 0; }
//    }
//    """.trimIndent()
//    }
//
//    var currentPage by remember { mutableStateOf(if (getLoggedInState()) AppPage.DASHBOARD else AppPage.LOGIN) }
//    var warehouseItems by remember { mutableStateOf<List<WarehouseItem>>(emptyList()) }
//    var showLogoutModal by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        while (true) {
//            warehouseItems = WarehouseApi.getItems()
//            delay(5000) // refresh every 5 seconds
//        }
//    }
//
//    Div {
//        when (currentPage) {
//            AppPage.LOGIN -> LoginPage {
//                saveLoggedInState(true)
//                currentPage = AppPage.DASHBOARD
//            }
//            AppPage.DASHBOARD -> DashboardPage(
//                onNavigateInventory = { currentPage = AppPage.INVENTORY },
//                onNavigateWarehouse = { currentPage = AppPage.WAREHOUSE },
//                onNavigateReports = { currentPage = AppPage.REPORTS },
//                onNavigateSettings = { currentPage = AppPage.SETTINGS },
//                onLogout = { showLogoutModal = true },
//                warehouseItems = warehouseItems
//            )
//            AppPage.WAREHOUSE -> WarehousePage(onBack = { currentPage = AppPage.DASHBOARD })
//            AppPage.REPORTS -> ReportsPage(onBack = { currentPage = AppPage.DASHBOARD })
//            AppPage.SETTINGS -> SettingsPage(
//                onLogout = { showLogoutModal = true },
//                onBack = { currentPage = AppPage.DASHBOARD }
//            )
//            else -> {}
//        }
//
//        if (currentPage != AppPage.LOGIN) {
//            AppFooter(version = "v1.2.3")
//        }
//
//        ConfirmationModal(
//            message = "Are you sure you want to logout?",
//            isVisible = showLogoutModal,
//            onConfirm = {
//                saveLoggedInState(false)
//                currentPage = AppPage.LOGIN
//                showLogoutModal = false
//            },
//            onCancel = { showLogoutModal = false }
//        )
//    }
//}
//
//
//
//
//
//
package org.example.project.maguchilogic.pages

import AppFooter
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.browser.window
import org.example.project.maguchilogic.pages.appstylesheetlogic.WarehousePage
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Style

enum class AppPage {
    LOGIN, DASHBOARD, WAREHOUSE, REPORTS, SETTINGS
}

fun pageToUrl(page: AppPage): String = when (page) {
    AppPage.LOGIN -> "/login"
    AppPage.DASHBOARD -> "/dashboard"
    AppPage.WAREHOUSE -> "/warehouse"
    AppPage.REPORTS -> "/reports"
    AppPage.SETTINGS -> "/settings"
}

fun urlToPage(url: String): AppPage = when {
    url.endsWith("/dashboard") -> AppPage.DASHBOARD
    url.endsWith("/warehouse") -> AppPage.WAREHOUSE
    url.endsWith("/reports") -> AppPage.REPORTS
    url.endsWith("/settings") -> AppPage.SETTINGS
    else -> if (getLoggedInState()) AppPage.DASHBOARD else AppPage.LOGIN
}

@Composable
fun MaguchiLogicApp() {
    Style {
        """
        @keyframes shimmer {
            0% { background-position: -200% 0; }
            100% { background-position: 200% 0; }
        }
        """.trimIndent()
    }

    var currentPage by remember { mutableStateOf(urlToPage(window.location.pathname)) }
    var warehouseItems by remember { mutableStateOf<List<WarehouseItem>>(emptyList()) }
    var showLogoutModal by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            warehouseItems = WarehouseApi.getItems()
            delay(5000)
        }
    }

    // Block back button on login
    DisposableEffect(currentPage) {
        val handler = { _: dynamic ->
            if (!getLoggedInState()) {
                // Always redirect to login if logged out
                window.history.pushState(null, "", pageToUrl(AppPage.LOGIN))
                currentPage = AppPage.LOGIN
            } else {
                currentPage = urlToPage(window.location.pathname)
            }
        }
        window.onpopstate = handler
        onDispose { window.onpopstate = null }
    }

    fun navigateTo(page: AppPage, replace: Boolean = false) {
        currentPage = page
        val history: dynamic = window.history
        val url = pageToUrl(page)

        if (replace) {
            history.replaceState(null, "", url)
        } else {
            history.pushState(null, "", url)
        }
    }

    Div {
        when (currentPage) {
            AppPage.LOGIN -> LoginPage {
                saveLoggedInState(true)
                // Push dashboard page, replace login history so back won't go back
                navigateTo(AppPage.DASHBOARD, replace = true)
            }

            AppPage.DASHBOARD -> DashboardPage(
                warehouseItems = warehouseItems,
                onNavigateDashboard = { navigateTo(AppPage.DASHBOARD) },
                onNavigateWarehouse = { navigateTo(AppPage.WAREHOUSE) },
                onNavigateReports = { navigateTo(AppPage.REPORTS) },
                onNavigateSettings = { navigateTo(AppPage.SETTINGS) },
                onLogout = { showLogoutModal = true }
            )

            AppPage.WAREHOUSE -> WarehousePage(onBack = { navigateTo(AppPage.DASHBOARD) })
            AppPage.REPORTS -> ReportsPage(
                onBack = { navigateTo(AppPage.DASHBOARD) },
                warehouseItems = warehouseItems
            )
            AppPage.SETTINGS -> SettingsPage(
                onBack = { navigateTo(AppPage.DASHBOARD) },
                onLogout = { showLogoutModal = true }
            )
        }

        if (currentPage != AppPage.LOGIN) {
            AppFooter(version = "v1.2.3")
        }

        ConfirmationModal(
            message = "Are you sure you want to logout?",
            isVisible = showLogoutModal,
            onConfirm = {
                saveLoggedInState(false)
                // Replace history with login page and push a dummy state to block back
                window.history.replaceState(null, "", pageToUrl(AppPage.LOGIN))
                window.history.pushState(null, "", pageToUrl(AppPage.LOGIN))
                currentPage = AppPage.LOGIN
                showLogoutModal = false
            },
            onCancel = { showLogoutModal = false }
        )
    }
}



