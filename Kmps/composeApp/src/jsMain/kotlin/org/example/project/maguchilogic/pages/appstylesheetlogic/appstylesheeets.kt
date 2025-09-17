package org.example.project.maguchilogic.pages.appstylesheetlogic
import androidx.compose.ui.input.key.Key.Companion.Focus
import org.jetbrains.compose.web.attributes.AutoComplete.Companion.on
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {

    val content by style {
        padding(16.px)
        margin(16.px)
        borderRadius(12.px)
        property("background", "rgba(255, 255, 255, 0.2)")
        property("backdrop-filter", "blur(10px)")
        property("-webkit-backdrop-filter", "blur(10px)")
        property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.1)")
        property("transition", "all 0.3s ease")

        hover {
            property("background", "rgba(255, 255, 255, 0.35)")
            property("box-shadow", "0 12px 40px 0 rgba(31, 38, 135, 0.2)")
        }
    }

    val userCard by style {
        padding(12.px)
        margin(12.px, 0.px)
        borderRadius(8.px)
        property("background", "rgba(255, 255, 255, 0.2)")
        property("backdrop-filter", "blur(8px)")
        property("-webkit-backdrop-filter", "blur(8px)")
        property("box-shadow", "0 4px 16px 0 rgba(31, 38, 135, 0.05)")
    }

    val page by style {
        padding(24.px)
        fontFamily("Arial, sans-serif")
        backgroundColor(rgb(245, 245, 245))
        minHeight(100.vh)
    }

    val loginCard by style {
        padding(32.px)
        width(320.px)
        margin(64.px)
        backgroundColor(Color.white)
        borderRadius(12.px)
        property("box-shadow", "0px 4px 16px rgba(0, 0, 0, 0.15)")
        property("transition", "all 0.3s ease")

        hover {
            property("box-shadow", "0px 6px 20px rgba(0, 0, 0, 0.25)")
        }
    }

    val loginInput by style {
        padding(8.px)
        margin(8.px)
        width(200.px)
    }


    val loginButtonColor = rgb(50, 205, 50)          // green
    val loginButtonHoverColor = rgb(60, 220, 60)     // lighter green

    val loginButton by style {
        padding(8.px, 16.px)
        margin(8.px)
        backgroundColor(loginButtonColor)  // CSSColorValue
        color(Color.white)                 // Text stays white
        borderRadius(4.px)
        property("border-style", "none")
        cursor("pointer")
        property("transition", "all 0.3s ease")

        hover {
            backgroundColor(loginButtonHoverColor)
            color(loginButtonColor)
        }
    }


    val dashboard by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        minHeight(80.vh)
    }

    val sidebar by style {
        width(240.px)
        backgroundColor(rgb(245, 245, 245)) // Light menu background like login page
        color(rgb(50, 50, 50))
        padding(24.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        property("transition", "all 0.3s ease")
        property("backdrop-filter", "blur(10px)")
        property("-webkit-backdrop-filter", "blur(10px)")
        property("border-radius", "12px")
        property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.05)")
    }

    val sidebarItem by style {
        marginTop(12.px)
        cursor("pointer")
        padding(10.px)
        borderRadius(12.px)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Start)
        fontWeight("normal")
        color(Color.white) // white text by default for unselected
        backgroundColor(rgb(33, 150, 243)) // blue background for unselected
        property("transition", "all 0.3s ease")
        property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.1)")
        property("backdrop-filter", "blur(10px)")
        property("-webkit-backdrop-filter", "blur(10px)")

        hover {
            backgroundColor(rgb(30, 136, 229)) // slightly darker blue on hover
        }
    }

    val sidebarItemSelected by style {
        self {
            backgroundColor(rgb(0, 180, 0)) // slightly lighter green
            color(Color.white) // text stays white
            fontWeight("bold")
            property("transition", "all 0.3s ease")

            hover {
                backgroundColor(rgb(0, 200, 0)) // slightly lighter green on hover
            }
        }
    }


    // --- NEW: universal selected style ---
    val selected by style {
        backgroundColor(rgb(0, 128, 0)) // green
        color(Color.white)
        fontWeight("bold")
        property("transition", "all 0.3s ease")
    }

    val mainContent by style {
        flexGrow(1)
        padding(24.px)
        backgroundColor(rgb(245, 245, 245))
    }

    val backButton by style {
        padding(8.px, 16.px)
        backgroundColor(rgb(245, 245, 245)) // Light color like login page
        borderRadius(6.px)
        color(Color.black)
        property("border-style", "none")
        cursor("pointer")
        property("transition", "all 0.3s ease")

        hover {
            backgroundColor(rgb(230, 230, 230))
        }
    }

    val settingsInput by style {
        padding(8.px)
        width(250.px)
        borderRadius(6.px)
        border(1.px, LineStyle.Solid, rgb(200, 200, 200))
        property("transition", "all 0.3s ease")
        property("border-color", rgb(200, 200, 200))

        self {
            property("border-color", rgb(100, 149, 237))
        }
    }

    val stockCard by style {
        width(150.px)
        height(100.px)
        backgroundColor(rgb(70, 130, 180))
        color(Color.white)
        borderRadius(8.px)
        padding(16.px)
        property("box-shadow", "0px 2px 6px rgba(0, 0, 0, 0.1)")
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.SpaceBetween)
        property("transition", "all 0.3s ease")

        hover {
            backgroundColor(rgb(100, 160, 210))
        }
    }

    val stockTitle by style {
        fontSize(14.px)
        opacity(0.8)
    }

    val stockCount by style {
        margin(0.px)
    }

    val barContainer by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceEvenly)
        alignItems(AlignItems.End)
        height(200.px)
        padding(20.px)
        gap(16.px)
    }

    val barItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
    }

    val bar by style {
        width(40.px)
        borderRadius(6.px)
        property("box-shadow", "2px 2px 6px gray")
    }

    val barLabel by style {
        marginTop(6.px)
        fontSize(14.px)
        fontWeight("bold")
        color(Color.black)
    }

    val appIcon by style {
        width(120.px)
        height(120.px)
        property("transition", "transform 0.3s ease")
        hover { property("transform", "scale(1.1)") }
    }

    val tableHeader by style {
        backgroundColor(rgb(200, 200, 200))
        fontWeight("bold")
        padding(8.px)
        property("border-bottom", "1px solid rgb(150, 150, 150)")
    }


    // Menu / Dashboard / Warehouse buttons

    // Menu / Dashboard / Warehouse buttons
    // Menu / Dashboard / Warehouse buttons
    val menuButton by style {
        padding(12.px)
        width(90.percent)
        borderRadius(8.px)
        border(0.px)
        color(Color.white)
        fontWeight("bold")
        cursor("pointer")
        property("transition", "all 0.4s ease")
        backgroundImage("linear-gradient(90deg, #4a90e2, #50c3f7)") // unselected blue gradient

        self + hover style {
            backgroundColor(rgba(40, 167, 79, 0.9)) // green on hover
            backgroundImage("none")
            color(Color.white)
        }
    }

    // Selected / active menu button
    val menuButtonSelected by style {
        backgroundColor(rgba(40, 167, 79, 0.9)) // fixed green
        backgroundImage("none")                  // important to remove gradient
        color(Color.white)
        fontWeight("bold")
        property("transition", "all 0.3s ease")

        // Hover should not change anything for selected button
        self + hover style {
            backgroundColor(rgba(40, 167, 79, 0.9)) // same green
            backgroundImage("none")
            color(Color.white)
        }
    }
    val tableRow by style {
        padding(8.px)
        property("border-bottom", "1px solid rgba(220,220,220,1)")

        hover {
            backgroundColor(rgba(245, 245, 245, 0.6))
        }
    }
    val warehouseButton by style {
        padding(8.px, 16.px)
        borderRadius(6.px)
        border(0.px)
        backgroundColor(rgba(0, 180, 0, 1.0)) // solid green
        color(Color.white)                    // text white
        cursor("pointer")
        fontWeight("bold")
        property("transition", "all 0.3s ease")

        self + hover style {
            backgroundColor(rgba(0, 180, 0, 1.0)) // same green on hover
            color(Color.white)
        }
    }

}





