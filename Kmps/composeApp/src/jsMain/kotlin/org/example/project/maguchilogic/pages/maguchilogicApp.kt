package org.example.project.maguchilogic.pages

import AppFooter
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.appstylesheetlogic.WarehousePage
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.*

enum class AppPage {
    LOGIN, DASHBOARD, INVENTORY, ADD_ITEM, WAREHOUSE, REPORTS, SETTINGS
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

    var currentPage by remember { mutableStateOf(if (getLoggedInState()) AppPage.DASHBOARD else AppPage.LOGIN) }
    var warehouseItems by remember { mutableStateOf<List<WarehouseItem>>(emptyList()) }
    var showLogoutModal by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            warehouseItems = WarehouseApi.getItems()
            delay(5000) // refresh every 5 seconds
        }
    }

    Div {
        when (currentPage) {
            AppPage.LOGIN -> LoginPage {
                saveLoggedInState(true)
                currentPage = AppPage.DASHBOARD
            }
            AppPage.DASHBOARD -> DashboardPage(
                onNavigateInventory = { currentPage = AppPage.INVENTORY },
                onNavigateWarehouse = { currentPage = AppPage.WAREHOUSE },
                onNavigateReports = { currentPage = AppPage.REPORTS },
                onNavigateSettings = { currentPage = AppPage.SETTINGS },
                onLogout = { showLogoutModal = true },
                warehouseItems = warehouseItems
            )
            AppPage.WAREHOUSE -> WarehousePage(onBack = { currentPage = AppPage.DASHBOARD })
            AppPage.REPORTS -> ReportsPage(onBack = { currentPage = AppPage.DASHBOARD })
            AppPage.SETTINGS -> SettingsPage(
                onLogout = { showLogoutModal = true },
                onBack = { currentPage = AppPage.DASHBOARD }
            )
            else -> {}
        }

        if (currentPage != AppPage.LOGIN) {
            AppFooter(version = "v1.2.3")
        }

        ConfirmationModal(
            message = "Are you sure you want to logout?",
            isVisible = showLogoutModal,
            onConfirm = {
                saveLoggedInState(false)
                currentPage = AppPage.LOGIN
                showLogoutModal = false
            },
            onCancel = { showLogoutModal = false }
        )
    }
}






