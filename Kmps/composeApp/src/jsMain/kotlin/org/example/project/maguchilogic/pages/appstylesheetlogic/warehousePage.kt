package org.example.project.maguchilogic.pages.appstylesheetlogic

import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.px


import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.example.project.AppStylesheet.hover
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
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

    // Load items on first composition
    LaunchedEffect(Unit) {
        val fetchedItems = WarehouseApi.getItems()
        items.clear()
        items.addAll(fetchedItems)
    }

    Div({ classes(AppStylesheet.content) }) {

        // Page Title
        H3({ style { marginBottom(24.px) } }) {
            Text("Warehouse Items")
        }

        // Back Button
        Button({
            classes(AppStylesheet.backButton)
            onClick { onBack() }
            style { marginBottom(24.px) }
        }) { Text("Back to Dashboard") }

        // Input Fields & Add Button
        Div({
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(12.px)
                marginBottom(24.px)
            }
        }) {
            Input(InputType.Text, attrs = {
                placeholder("Item Name")
                value(name)
                onInput { name = it.value }
                style { width(180.px) }
            })

            Input(InputType.Number, attrs = {
                placeholder("Quantity")
                value(quantity)
                onInput { quantity = it.value.toString() }
                style { width(120.px) }
            })

            Input(InputType.Date, attrs = {
                value(date)
                onInput { date = it.value }
                style { width(160.px) }
            })

            Input(InputType.Text, attrs = {
                placeholder("Location")
                value(location)
                onInput { location = it.value }
                style { width(160.px) }
            })

            // Add Item Button
            Button({
                classes(AppStylesheet.warehouseButton)
                style { width(120.px) }
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
                        // Clear fields
                        name = ""
                        quantity = ""
                        location = ""
                        date = ""
                    }
                }
            }) { Text("Add Item") }
        }

        // Table of items
        Table({
            style {
                width(100.percent)
                property("border-collapse", "collapse")
                property("border-spacing", "0")
            }
        }) {
            Thead {
                Tr({
                    style {
                        backgroundColor(rgba(33, 150, 243, 0.9))
                        color(Color.white)
                    }
                }) {
                    listOf("ID", "Name", "Quantity", "Expiry Date", "Location", "Actions").forEach { header ->
                        Th({ style { padding(12.px); textAlign("left") } }) { Text(header) }
                    }
                }
            }

            Tbody {
                items.forEach { item ->
                    Tr({
                        style { backgroundColor(rgba(245, 245, 245, 0.9)); marginBottom(4.px) }
                    }) {
                        Td({ style { padding(10.px) } }) { Text(item.id.toString()) }
                        Td({ style { padding(10.px) } }) { Text(item.name) }
                        Td({ style { padding(10.px) } }) { Text(item.quantity.toString()) }
                        Td({ style { padding(10.px) } }) { Text(item.expiryDate) }
                        Td({ style { padding(10.px) } }) { Text(item.location) }

                        // Delete Button
                        Td({ style { padding(10.px) } }) {
                            Button({
                                classes(AppStylesheet.warehouseButton)
                                style { width(100.px) }
                                onClick {
                                    scope.launch {
                                        WarehouseApi.deleteItem(item.id)
                                        items.remove(item)
                                    }
                                }
                            }) { Text("Delete") }
                        }
                    }
                }
            }
        }
    }
}

