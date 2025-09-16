package org.example.project.maguchilogic.pages
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontStyle
import kotlinx.coroutines.launch
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.*

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontStyle
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px

@Composable
fun InventoryPage(onAddNewItem: () -> Unit) {
    var items by remember { mutableStateOf<List<WarehouseItem>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Style(AppStylesheet)
    Div({ classes(AppStylesheet.content) }) {
        H2({ style { marginBottom(16.px) } }) { Text("Inventory") }
        // Action Buttons
        Div({ style { display(DisplayStyle.Flex); gap(12.px); marginBottom(16.px) } }) {
            Button({
                classes(AppStylesheet.loginButton)
                onClick {
                    loading = true
                    scope.launch {
                        items = WarehouseApi.getItems()
                        loading = false
                    }
                }
            }) { Text("Load Inventory") }
            Button({
                classes(AppStylesheet.loginButton)
                onClick { onAddNewItem() }
            }) { Text("Add New Item") }
        }
        // Loading Indicator
        if (loading) Div({ style { marginBottom(16.px) } }) { Text("⏳ Loading...") }
        // Inventory Items
        items.forEach { item ->
            Div({ classes(AppStylesheet.userCard) }) {
                P { Text("Name: ${item.name}") }
                P { Text("Quantity: ${item.quantity}") }
                P { Text("Expiry: ${item.expiryDate}") }
                P { Text("Location: ${item.location}") }

                Button({
                    classes(AppStylesheet.loginButton)
                    style { marginTop(8.px) }
                    onClick {
                        scope.launch {
                            WarehouseApi.deleteItem(item.id)
                            items = WarehouseApi.getItems()
                        }
                    }
                }) { Text("Delete") }
            }
        }
        // Show message if no items loaded
        if (!loading && items.isEmpty()) {
            Div({ style {
                marginTop(16.px)
                property("font-style", "italic")
            } }) { Text("No inventory items loaded.") }

        }
        }
    }


