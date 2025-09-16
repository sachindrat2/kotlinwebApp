package org.example.project

import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.dom.*
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.rgb

@Composable
fun HomePage() {
    // Dynamic greeting
    Greetingz()

    var clickCount by remember { mutableStateOf(0) }

    // Main container
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            padding(48.px)
        }
    }) {
        P({
            style {
                fontSize(18.px)
                marginBottom(24.px)
                textAlign("center")
                maxWidth(600.px)
            }
        }) {
            Text("Driving enterprise innovation through digital transformation, AI, and automation solutions that scale.")
        }

        Button({
            style {
                padding(12.px, 24.px)
                fontSize(16.px)
                cursor("pointer")
                borderRadius(8.px)
                border(0.px)
                backgroundColor(rgb(41, 128, 185))
                color(rgb(255, 255, 255))
            }
            onClick { clickCount++ }
        }) {
            Text(if (clickCount == 0) "Our Projects" else "Clicked $clickCount times!")
        }
    }
}

@Composable
fun Greetingz() {
    // Get current hour in JS
    val hour = js("new Date().getHours()") as Int
    val message = when (hour) {
        in 5..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        in 17..20 -> "Good Evening"
        else -> "Hello"
    }

    H1({
        style {
            textAlign("center")
            marginBottom(24.px)
            fontSize(36.px)
        }
    }) {
        Text("$message! Welcome to our site")
    }
}
