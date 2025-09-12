package org.example.project

import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {

    // 🌟 Page container
    val page by style {
        property("font-family", "Arial, sans-serif")
        margin(0.px)
        padding(0.px)
    }
    val sectionTitle by style {
        fontSize(32.px)
        fontWeight("bold")
        marginBottom(40.px)
        textAlign("center")
    }
    val content by style {
        padding(20.px)
        fontSize(18.px)

        color(rgb(50, 50, 50))

        media(mediaMaxWidth(600.px)) {
            self style {
                fontSize(16.px)
                padding(10.px)
            }
        }
    }

    // 🏠 Header
    val header by style {
        backgroundColor(rgb(52, 152, 219))
        color(Color.white)
        padding(16.px)
        textAlign("center")
    }

    // 🌐 Navigation
    val nav by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        gap(20.px)
        backgroundColor(rgb(41, 128, 185))
        padding(10.px)

        media(mediaMaxWidth(600.px)) {
            self style {
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                gap(10.px)
            }
        }
    }

    val navLink by style {
        color(Color.white)
        textDecoration("none")
        fontWeight("bold")
        padding(6.px, 10.px)
        hover { color(rgb(200, 200, 200)) }
    }

    // 🎯 Hero Section
    val hero by style {
        padding(80.px, 20.px)
        textAlign("center")
        background("linear-gradient(135deg, #6DD5FA, #2980B9)")
        color(Color.white)
    }

    val heroText by style {
        maxWidth(600.px)
        margin(0.px, )
    }

    val ctaButton by style {
        display(DisplayStyle.InlineBlock)
        padding(12.px, 24.px)
        backgroundColor(rgb(231, 76, 60))
        color(Color.white)
        borderRadius(30.px)
        fontSize(18.px)
        fontWeight("bold")
        textDecoration("none")
        marginTop(16.px)
        property("transition", "transform 0.3s ease, box-shadow 0.3s ease")

        hover {
            backgroundColor(rgb(192, 57, 43))
            property("transform", "scale(1.05)")
            property("box-shadow", "0px 4px 10px rgba(0,0,0,0.2)")
        }
    }

    // ✨ Features Section
    val featuresSection by style {
        padding(60.px, 20.px)
        backgroundColor(rgb(245, 245, 245))
        textAlign("center")
    }

    val featureRow by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        gap(40.px)
        flexWrap(FlexWrap.Wrap)
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val feature by style {
        property("flex", "1 1 300px")
        maxWidth(300.px)
        padding(20.px)
        backgroundColor(Color.white)
        borderRadius(12.px)
        property("box-shadow", "0px 4px 12px rgba(0,0,0,0.1)")
        property("transition", "transform 0.3s ease, box-shadow 0.3s ease")

        hover {
            backgroundColor(rgb(240, 240, 240)) // subtle light grey
            property("transform", "scale(1.02)") // optional slight scale
            property("box-shadow", "0px 4px 8px rgba(0,0,0,0.1)")

        }

    }

    // 📖 About Section
    val aboutSection by style {
        padding(60.px, 20.px)
        textAlign("center")

        media(mediaMaxWidth(600.px)) {
            self style {
                padding(20.px)
                width(100.percent)
            }
        }
    }

    // 🎯 Call-to-Action Section
    val ctaSection by style {
        padding(80.px, 20.px)
        textAlign("center")
        background("linear-gradient(135deg, #ff6a00, #ee0979)")
        color(Color.white)
        borderRadius(12.px)
    }

    // 📄 Footer
    val footer by style {
        backgroundColor(rgb(52, 73, 94))
        color(Color.white)
        padding(10.px)
        textAlign("center")
    }
}
