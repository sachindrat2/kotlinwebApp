package org.example.project.maguchilogic.pages.appstylesheetlogic

import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import org.jetbrains.compose.web.css.*




object LoginStylesheet : StyleSheet() {

    val page by style {
        // Dark blue to black gradient background
        backgroundImage("linear-gradient(135deg, #0f2027, #203a43, #2c5364)")
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        height(100.vh)
        width(100.vw)
        fontFamily("Arial, sans-serif")
    }

    val loginCard by style {
        backgroundColor(rgba(0, 0, 0, 0.4)) // dark frosted glass
        property("backdrop-filter", "blur(16px) saturate(180%)")
        borderRadius(20.px)
        border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
        property("box-shadow", "0 8px 32px rgba(0, 0, 0, 0.3)")

        padding(32.px)
        width(340.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Stretch)
        gap(20.px)
        color(Color.white)
    }

    val appIcon by style {
        width(120.px)
        height(120.px)
        marginBottom(12.px)
        alignSelf(AlignSelf.Center)
    }

    val loginInput by style {
        padding(12.px)
        borderRadius(10.px)
        border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.2))
        backgroundColor(rgba(20, 30, 50, 0.6)) // dark blue tinted input
        color(Color.white)
        width(100.percent)
        property("box-sizing", "border-box")
        property("::placeholder", "color: rgba(200,200,200,0.5)")
    }

    val loginButton by style {
        padding(14.px)
        width(100.percent)
        borderRadius(10.px)
        border(0.px)
        backgroundImage("linear-gradient(90deg, #1c1c2b, #2a2a4d)") // dark gradient
        color(Color.white)
        fontWeight("bold")
        cursor("pointer")
        property("transition", "all 0.4s ease")
        self + hover style {
            backgroundColor(rgb(40, 167, 69)) // green on hover
            backgroundImage("none")
            color(Color.white)
        }
    }

    val toggleButton by style {
        position(Position.Absolute)
        right(8.px)
        top(50.percent)
        property("transform", "translateY(-50%)")
        backgroundColor(rgba(50, 50, 70, 0.6))
        border(0.px)
        borderRadius(6.px)
        padding(4.px, 8.px)
        color(Color.white)
        cursor("pointer")
        fontSize(12.px)
        property("transition", "background-color 0.3s ease")
        self + hover style {
            backgroundColor(rgba(40, 167, 69, 0.7))
            color(Color.white)
        }
    }

    val errorText by style {
        color(rgb(220, 53, 69)) // red for errors
        marginBottom(8.px)
        fontSize(14.px)
        textAlign("center")
    }
}


