package org.example.project
import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun Footers() {
    Footer({
        style {
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            padding(24.px)
            backgroundColor(rgb(40, 55, 71)) // dark blue-gray
            color(Color.white)
            marginTop(48.px)
            fontSize(14.px)
            textAlign("center")
        }
    }) {
        P {
            Text("© 2025 Maguchi Group DX Team — Empowering Enterprise Solutions")
        }
    }
}
