package org.example.project.maguchilogic.pages.appstylesheetlogic

import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import org.jetbrains.compose.web.css.*




object LoginStylesheet : StyleSheet() {

    val page by style {
        // Lighter gradient background
        backgroundImage("linear-gradient(135deg, #1c2a38, #2a3a4d, #3b4f65)")
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        height(100.vh)
        width(100.vw)
        fontFamily("Arial, sans-serif")
    }

    val loginCard by style {
        backgroundColor(rgba(255, 255, 255, 0.15)) // lighter frosted glass
        property("backdrop-filter", "blur(12px) saturate(150%)")
        borderRadius(16.px)
        border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.2))
        property("box-shadow", "0 4px 24px rgba(0, 0, 0, 0.15)")

        padding(24.px)
        width(300.px) // reduced width
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Stretch)
        gap(16.px)
        color(Color.white)
    }

    val appIcon by style {
        width(100.px) // slightly smaller
        height(100.px)
        marginBottom(10.px)
        alignSelf(AlignSelf.Center)
    }

    val loginInput by style {
        padding(10.px)
        borderRadius(8.px)
        border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.2))
        backgroundColor(rgba(255, 255, 255, 0.1)) // lighter tinted input
        color(Color.white)
        width(100.percent)
        property("box-sizing", "border-box")
        property("::placeholder", "color: rgba(255,255,255,0.6)")
    }

    val loginButton by style {
        padding(12.px)
        width(100.percent)
        borderRadius(8.px)
        border(0.px)
        backgroundImage("linear-gradient(90deg, #4a90e2, #50c3f7)") // lighter gradient
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
        backgroundColor(rgba(100, 100, 120, 0.4)) // lighter toggle button
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
        marginBottom(6.px)
        fontSize(13.px)
        textAlign("center")
    }
}



