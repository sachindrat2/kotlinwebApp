package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import org.example.project.AppStylesheet.attr
import org.jetbrains.compose.web.css.Style
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.svg.Svg
import org.jetbrains.compose.web.svg.Rect
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.height
import org.jetbrains.compose.web.svg.width

@OptIn(ExperimentalComposeWebSvgApi::class, ExperimentalComposeWebSvgApi::class)
@Composable
fun ReportsPage(onBack: () -> Unit) {
    Style(AppStylesheet)

    val data = listOf(5, 10, 7, 3, 8) // dummy data
    val colors = listOf("steelblue", "tomato", "orange", "green", "purple")
    val barWidth = 30
    val spacing = 10

    Div({ classes(AppStylesheet.content) }) {
        H3 { Text("Reports") }
        // Back button
        Button({
            classes(AppStylesheet.backButton)
            onClick { onBack() }
            style {
                marginBottom(16.px)
            }
        }) { Text("← Back") }

        H3 { Text("Reports") }
        Svg(attrs = {
            // set width and height as attributes
            this.width(400)
            this.height(200)
        }) {
            data.forEachIndexed { index, value ->

                Rect(
                    x = index * (barWidth + spacing),
                    y = 200 - value * 15,
                    width = barWidth,
                    height = value * 15,
                    attrs = {
                        attr("fill", colors.getOrElse(index) { "gray" })
                    }
                )

            }
        }
    }
}
