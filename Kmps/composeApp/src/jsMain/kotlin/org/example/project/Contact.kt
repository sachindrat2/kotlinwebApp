package org.example.dxteam

import androidx.compose.runtime.Composable

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactPage() {
    Div({
        style {
            padding(120.px, 24.px, 40.px, 24.px) // top padding for navbar
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            backgroundColor(rgb(245, 246, 250)) // light gray background
            color(rgb(30, 30, 30))
            textAlign("center")
        }
    }) {
        H2({
            style {
                fontSize(28.px)
                fontWeight("bold")
                marginBottom(16.px)
            }
        }) { Text("Contact Us") }

        P({ style { fontSize(16.px); marginBottom(8.px) } }) {
            Text("📧 Email: dx-team@maguchi-group.com")
        }

        P({ style { fontSize(16.px); marginBottom(8.px) } }) {
            Text("☎ Phone: +81-XXX-XXXX-XXXX")
        }

        P({ style { fontSize(16.px); marginBottom(24.px) } }) {
            Text("🏢 Address: Maguchi Group Headquarters, Tokyo, Japan")
        }

        // Optional "Get in Touch" button
        Button({
            style {
                padding(12.px, 24.px)
                fontSize(16.px)
                fontWeight("bold")
                backgroundColor(rgb(52, 152, 219)) // corporate blue
                color(Color.white)
                border(0.px)
                borderRadius(8.px)
                cursor("pointer")
                property("hover", "background-color: rgb(41,128,185)")
            }
            onClick { println("Get in Touch clicked!") }
        }) {
            Text("Get in Touch")
        }
    }
}
