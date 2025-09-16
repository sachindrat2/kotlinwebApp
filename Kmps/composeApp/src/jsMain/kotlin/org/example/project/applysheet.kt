package org.example.project
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {
    val content by style {
        width(100.percent)
        maxWidth(1200.px)
        margin(0.px)
        padding(16.px)
    }

    val homeContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        padding(48.px)
    }

    val homeTitle by style {
        fontSize(36.px)
        marginBottom(16.px)
        textAlign("center")
    }

    val homeText by style {
        fontSize(18.px)
        marginBottom(24.px)
        textAlign("center")
        maxWidth(600.px)
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val homeButton by style {
        padding(12.px, 24.px)
        fontSize(16.px)
        cursor("pointer")
        borderRadius(8.px)
        border(0.px)
        backgroundColor(rgb(41, 128, 185))
        color(rgb(255, 255, 255))
        property("transition", "transform 0.2s ease")
        hover {
            transform { scale(1.05) }
        }
    }

    // AboutPage container
    val aboutContainer by style {
        padding(120.px, 24.px, 40.px, 24.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        backgroundColor(rgb(245, 246, 250))
        color(rgb(30, 30, 30))
    }

    val aboutTitle by style {
        fontSize(28.px)
        fontWeight("bold")
        marginBottom(16.px)
        textAlign("center")
    }

    val aboutText by style {
        fontSize(16.px)
        maxWidth(700.px)
        property("line-height", "1.5")
        textAlign("center")
        marginBottom(32.px)
    }

    // Card container
    val cardContainer by style {
        display(DisplayStyle.Flex)
        flexWrap(FlexWrap.Wrap)
        justifyContent(JustifyContent.Center)
        gap(24.px)
    }

    // Individual card
    val card by style {
        backgroundColor(Color.white)
        padding(24.px)
        borderRadius(12.px)
        property("box-shadow", "0px 2px 8px rgba(0,0,0,0.1)")
        width(220.px)
        textAlign("center")
        cursor("default")
        property("transition", "box-shadow 0.3s")

        selector(":hover") style {
            property("box-shadow", "0px 4px 12px rgba(0,0,0,0.15)")
        }
    }

    val cardTitle by style {
        marginBottom(8.px)
        fontWeight("bold")
    }

    val cardText by style {
        fontSize(14.px)
        property("line-height", "1.5")
    }
    val projectCard by style {
        backgroundColor(Color.white)
        padding(24.px)
        borderRadius(12.px)
        property("box-shadow", "0px 2px 8px rgba(0,0,0,0.1)")
        width(260.px)
        textAlign("center")
        cursor("default")
        property("transition", "box-shadow 0.3s") // smooth hover effect

        selector(":hover") style {
            property("box-shadow", "0px 4px 12px rgba(0,0,0,0.15)")
        }
    }


    val projectCardTitle by style {
        marginBottom(12.px)
        fontSize(18.px)
    }

    val projectCardDescription by style {
        fontSize(14.px)
        property("line-height", "1.5")
    }
    val buttonStyle by style {
        padding(12.px, 24.px)
        fontSize(16.px)
        fontWeight("bold")
        backgroundColor(rgb(236, 240, 241))
        color(rgb(52, 73, 94))
        border(0.px)
        borderRadius(8.px)
        cursor("pointer")
        property(
            value = "background-color 0.3s ease",
            propertyName =  "background-color",
        )
    }

    val buttonHover by style {
        selector(":hover") style {
            backgroundColor(rgb(189, 195, 199))
        }
    }
    val page by style {
        property("font-family", "Inter, Arial, sans-serif")
        margin(0.px)
        padding(0.px)
        backgroundColor(rgb(245, 246, 250))
        color(rgb(30, 30, 30))
    }

    // Navbar
    val navbar by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(16.px)
        backgroundColor(rgb(40, 55, 71))
        color(Color.white)
        position(Position.Fixed)
        top(0.px)
        left(0.px)
        right(0.px)
        property("z-index", "1000")
    }

    val logo by style {
        fontSize(20.px)
        fontWeight("bold")
        color(Color.white)
    }

    val navList by style {
        display(DisplayStyle.Flex)
        listStyle("none")
        margin(0.px)
        padding(0.px)
    }

    val navItem by style {
        marginLeft(24.px)
        cursor("pointer")
        color(Color.white)
        fontSize(14.px)
    }

    // Hover for navItem
    init {
        selector(":hover") style {
            color(rgb(200, 200, 200))
        }
    }

    // Hamburger (hidden on desktop)
    val hamburger by style {
        backgroundColor(Color.transparent)
        border(0.px)
        fontSize(24.px)
        color(Color.white)
        cursor("pointer")
        display(DisplayStyle.None)

        media(mediaMaxWidth(768.px)) {
            display(DisplayStyle.Block)
        }
    }

    // Mobile Menu Drawer
    val mobileMenu by style {
        display(DisplayStyle.None)
        backgroundColor(rgb(52, 73, 94))
        padding(16.px)
        position(Position.Absolute)
        top(60.px)
        right(0.px)
        left(0.px)

        media(mediaMaxWidth(768.px)) {
            // Use property() instead of display()
            property("display", "block")
        }
    }

    val mobileNavItem by style {
        padding(12.px)
        color(Color.white)
        cursor("pointer")
        fontSize(16.px)
        property("border-bottom", "1px solid rgb(70,90,110)")

        // Hover effect
        selector(":hover") style {
            backgroundColor(rgb(70, 90, 110))
        }
    }


    // Footer
    val footer by style {
        textAlign("center")
        padding(16.px)
        backgroundColor(rgb(230, 233, 239))
        marginTop(48.px)
        fontSize(14.px)
    }
}
