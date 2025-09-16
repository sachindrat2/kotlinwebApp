package org.example.project.maguchilogic.pages


import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.model.WarehouseApi
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.*

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign

@Composable
fun AddEditItemPage(onItemAdded: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    Style(AppStylesheet)

    Div({ classes(AppStylesheet.content) }) {
        H2({ style { marginBottom(24.px); textAlign("center") } }) { Text("Add / Edit Item") }

        if (error != null) {
            Div({ style { color(Color.red); marginBottom(16.px); textAlign("center") } }) {
                Text(error!!)
            }
        }

        // Input Fields
        Div({ style { display(DisplayStyle.Flex); flexDirection(FlexDirection.Column); gap(16.px) } }) {
            Input(InputType.Text, attrs = {
                placeholder("Name")
                value(name)
                onInput { name = it.value }
                classes(AppStylesheet.settingsInput)
            })

            Input(InputType.Number, attrs = {
                placeholder("Quantity")
                value(quantity)
                onInput { quantity = it.value?.toInt().toString() }
                classes(AppStylesheet.settingsInput)
            })

            Input(InputType.Text, attrs = {
                placeholder("Expiry YYYY-MM-DD")
                value(expiry)
                onInput { expiry = it.value }
                classes(AppStylesheet.settingsInput)
            })

            Input(InputType.Text, attrs = {
                placeholder("Location")
                value(location)
                onInput { location = it.value }
                classes(AppStylesheet.settingsInput)
            })
        }

        // Save Button
        Div({ style { marginTop(24.px); textAlign("center") } }) {
            Button({
                classes(AppStylesheet.loginButton)
                onClick {
                    if (name.isBlank() || quantity.isBlank() || expiry.isBlank() || location.isBlank()) {
                        error = "Please fill all fields"
                        return@onClick
                    }
                    scope.launch {
                        WarehouseApi.addItem(
                            WarehouseItem(
                                id = (0..9999).random(),
                                name = name,
                                quantity = quantity.toIntOrNull() ?: 0,
                                expiryDate = expiry,
                                location = location
                            )
                        )
                        onItemAdded()
                    }
                }
                style {
                    property("transition", "all 0.3s ease")
                }
            }) { Text("Save Item") }
        }
    }
}
