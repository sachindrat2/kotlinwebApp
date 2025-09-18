package org.example.project.maguchilogic.pages

import BackButton
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.Style
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.svg.Svg
import org.jetbrains.compose.web.svg.Rect
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.height
import org.jetbrains.compose.web.svg.width
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import kotlinx.browser.window
import org.example.project.AppStylesheet.hover
import org.example.project.maguchilogic.pages.generateCSV.downloadCSV
import org.example.project.maguchilogic.pages.generateCSV.generatePDF
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.svg.*
import org.example.project.maguchilogic.pages.model.WarehouseApi

@OptIn(ExperimentalComposeWebSvgApi::class)
@Composable
fun ReportsPage(onBack: () -> Unit, warehouseItems: List<WarehouseItem>) {
    Style(AppStylesheet)

    val data = warehouseItems.map { it.quantity } // use real warehouse data
    val labels = warehouseItems.map { it.name }
    val colors = listOf("steelblue", "tomato", "orange", "green", "purple")
    val barWidth = 30
    val spacing = 10

    Div({ classes(AppStylesheet.content) }) {
        // Page Header
        Div({
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
                marginBottom(24.px)
            }
        }) {
            BackButton { onBack() }


            H2({
                style {
                    textAlign("center")
                    property("flex", "1.0")
                    color(rgb(33, 33, 33))
                }
            }) { Text("Report Page") }

            Div { } // empty space to balance flex
        }

        // Export buttons
        Div({
            style {
                display(DisplayStyle.Flex)
                gap(12.px)
                marginBottom(24.px)
            }
        }) {
            Button({
                onClick { downloadCSV(warehouseItems) }
                style {
                    padding(8.px, 16.px)
                    borderRadius(6.px)
                    property("border", "none")
                    backgroundColor(rgb(60, 130, 200))
                    color(Color.white)
                    cursor("pointer")
                    property("transition", "background 0.2s ease")
                    property("transition", "background 0.2s ease")
                    property(":hover", "background-color: rgb(30, 150, 60);")
                }
            }) { Text("Export CSV") }

            Button({
                onClick { generatePDF(warehouseItems) }
                style {
                    padding(8.px, 16.px)
                    borderRadius(6.px)
                    property("border", "none")
                    backgroundColor(rgb(40, 180, 70))
                    color(Color.white)
                    cursor("pointer")
                    property("transition", "background 0.2s ease")
                    property("transition", "background 0.2s ease")
                    property(":hover", "background-color: rgb(30, 150, 60);")
                }
            }) { Text("Export PDF") }
        }

        // Chart
        Svg(attrs = {
            width((labels.size * (barWidth + spacing)).px)
            height(200)
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
