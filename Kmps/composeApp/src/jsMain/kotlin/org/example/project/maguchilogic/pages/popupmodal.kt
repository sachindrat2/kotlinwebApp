package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ConfirmationModal(
    message: String,
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    isVisible: Boolean
) {
    if (!isVisible) return

    // Semi-transparent background overlay
    Div({
        style {
            position(Position.Fixed)
            top(0.px)
            left(0.px)
            width(100.percent)
            height(100.percent)
            backgroundColor(rgba(0, 0, 0, 0.5))
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            property("z-index", "999")
        }
    }) {
        // Card in the middle
        Div({
            style {
                backgroundColor(rgb(255, 255, 255))
                padding(24.px)
                borderRadius(12.px)
                width(300.px)
                property("box-shadow", "0px 4px 12px rgba(0, 0, 0, 0.3)")
                textAlign("center")
            }
        }) {
            P({ style { marginBottom(16.px); fontSize(16.px); fontWeight("bold") } }) {
                Text(message)
            }

            Div({
                style {
                    display(DisplayStyle.Flex)
                    justifyContent(JustifyContent.SpaceEvenly)
                }
            }) {
                Button({
                    onClick { onConfirm() }
                    style {
                        padding(8.px, 16.px)
                        backgroundColor(rgb(220, 20, 60))
                        color(rgb(255, 255, 255))
                        borderRadius(6.px)
                        property("border", "none")

                        cursor("pointer")
                    }
                }) {
                    Text("Yes")
                }

                Button({
                    onClick { onCancel() }
                    style {
                        padding(8.px, 16.px)
                        backgroundColor(rgb(200, 200, 200))
                        color(rgb(50, 50, 50))
                        borderRadius(6.px)
                        property("border", "none")

                        cursor("pointer")
                    }
                }) {
                    Text("No")
                }
            }
        }
    }
}
