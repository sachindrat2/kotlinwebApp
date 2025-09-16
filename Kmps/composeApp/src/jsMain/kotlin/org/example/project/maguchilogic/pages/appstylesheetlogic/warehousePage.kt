package org.example.project.maguchilogic.pages.appstylesheetlogic

import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.px


import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*

@Composable
fun WarehousePage(onBack: () -> Unit) {
    Style(AppStylesheet)

    var items by remember { mutableStateOf(listOf<WarehouseItem>()) }
    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) { items = WarehouseApi.getItems() }

    Div({ classes(AppStylesheet.content) }) {
        H3 { Text("Warehouse Items") }

        Button({
            classes(AppStylesheet.backButton)
            onClick { onBack() }
            style { marginBottom(16.px) }
        }) { Text("Back to Dashboard") }

        Div({
            style {
                marginBottom(16.px)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(8.px)
            }
        }) {
            Input(InputType.Text, attrs = { placeholder("Item Name"); value(name); onInput { name = it.value }; style { width(150.px)} })
            Input(InputType.Number, attrs = { placeholder("Quantity"); value(quantity); onInput { quantity = it.value?.toInt().toString() }; style { width(100.px) } })
            Input(InputType.Date, attrs = { value(date); onInput { date = it.value }; style { width(150.px )} })
            Input(InputType.Text, attrs = { placeholder("Location"); value(location); onInput { location = it.value }; style { width(150.px )} })

            Button({
                classes(AppStylesheet.loginButton)
                style { height(40.px) }
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
                            items = items + newItem
                        }
                        name = ""; quantity = ""; location = ""; date = ""
                    }
                }
            }) { Text("Add Item") }
        }

        Table {
            Thead {
                Tr {
                    Th { Text("ID") }; Th { Text("Name") }; Th { Text("Quantity") }
                    Th { Text("Expiry Date") }; Th { Text("Location") }; Th { Text("Actions") }
                }
            }
            Tbody {
                items.forEach { item ->
                    Tr {
                        Td { Text(item.id.toString()) }
                        Td { Text(item.name) }
                        Td { Text(item.quantity.toString()) }
                        Td { Text(item.expiryDate) }
                        Td { Text(item.location) }
                        Td {
                            Button({
                                classes(AppStylesheet.loginButton)
                                onClick { scope.launch { WarehouseApi.deleteItem(item.id); items = items.filter { it.id != item.id } } }
                            }) { Text("Delete") }
                        }
                    }
                }
            }
        }
    }
}
