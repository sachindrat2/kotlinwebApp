package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
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
    var currentPage by remember { mutableStateOf(AppPage.LOGIN) }
    var warehouseItems by remember { mutableStateOf<List<WarehouseItem>>(emptyList()) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            warehouseItems = WarehouseApi.getItems() // Or your API call
        }
    }
    when (currentPage) {
        AppPage.LOGIN -> LoginPage { currentPage = AppPage.DASHBOARD }
        AppPage.DASHBOARD -> DashboardPage(
            onNavigateInventory = { currentPage = AppPage.INVENTORY },
            onNavigateWarehouse = { currentPage = AppPage.WAREHOUSE },
            onNavigateReports = { currentPage = AppPage.REPORTS },
            onNavigateSettings = { currentPage = AppPage.SETTINGS },
            onLogout = { currentPage = AppPage.LOGIN },
            warehouseItems =warehouseItems
        )
        AppPage.WAREHOUSE -> WarehousePage(onBack = { currentPage = AppPage.DASHBOARD })
        AppPage.REPORTS -> ReportsPage(onBack = { currentPage = AppPage.DASHBOARD })
        AppPage.SETTINGS -> SettingsPage(
            onLogout = { currentPage = AppPage.LOGIN },
            onBack = { currentPage = AppPage.DASHBOARD }
        )

        else -> {}
    }
}


