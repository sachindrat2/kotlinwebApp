package org.example.project.maguchilogic.pages.appstylesheetlogic
import androidx.compose.ui.input.key.Key.Companion.Focus
import org.jetbrains.compose.web.attributes.AutoComplete.Companion.on
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {

    val page by style {
        padding(24.px)
        fontFamily("Arial, sans-serif")
        backgroundColor(rgb(245, 245, 245))
        minHeight(100.vh)
    }
    val loginCard by style {
        padding(32.px)
        width(320.px)
        margin(64.px, )
        backgroundColor(Color.white)
        borderRadius(12.px)
        property("box-shadow", "0px 4px 16px rgba(0, 0, 0, 0.15)")
        property("transition", "all 0.3s ease")

        hover {
            property("box-shadow", "0px 6px 20px rgba(0, 0, 0, 0.25)")
        }
    }

    val content by style {
        padding(16.px)
        margin(16.px)
        backgroundColor(Color.white)
        borderRadius(8.px)
        property("box-shadow", "0px 2px 8px rgba(0,0,0,0.1)")
    }

    val loginInput by style {
        padding(8.px)
        margin(8.px)
        width(200.px)
    }

    val loginButton by style {
        padding(8.px, 16.px)
        margin(8.px)
        backgroundColor(rgb(33, 150, 243))
        color(Color.white)
        borderRadius(4.px)
        property("border-style", "none")
        cursor("pointer")
    }

    val userCard by style {
        padding(12.px)
        margin(12.px, 0.px)
        border(1.px, LineStyle.Solid, rgb(200, 200, 200))
        borderRadius(4.px)
    }
    val dashboard by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        minHeight(80.vh)
    }

    val sidebar by style {
        width(240.px)
        backgroundColor(rgb(33, 150, 243))
        color(Color.white)
        padding(24.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        property("transition", "all 0.3s ease")
    }

    val navLink by style {
        padding(12.px)
        margin(4.px, 0.px)
        color(Color.white)
        textDecoration("none")
        borderRadius(6.px)
        property("transition", "all 0.3s ease")

        hover {
            backgroundColor(rgb(30, 136, 229))
            cursor("pointer")
        }
    }

    val mainContent by style {
        flexGrow(1)
        padding(24.px)
        backgroundColor(rgb(245, 245, 245))
    }

    val backButton by style {
        padding(8.px, 16.px)
        backgroundColor(rgb(200, 200, 200))
        borderRadius(6.px)
        color(Color.black)
        property("border-style", "none")
        cursor("pointer")
        property("transition", "all 0.3s ease")

        hover {
            backgroundColor(rgb(169, 169, 169))
        }
    }
    val settingsInput by style {
        padding(8.px)
        width(250.px)
        borderRadius(6.px)
        border(1.px, LineStyle.Solid, rgb(200, 200, 200))

        property("transition", "all 0.3s ease")
        property("border-color", rgb(200, 200, 200))

        self  {
            property("border-color", rgb(100, 149, 237))
        }
    }


    val sidebarItem by style {
        marginTop(12.px)
        cursor("pointer")
        padding(10.px)
        borderRadius(6.px)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Start)
        fontWeight("normal")
        color(rgb(200, 200, 200))
        property("transition", "all 0.3s ease")
        property("box-shadow", "0px 2px 6px rgba(0, 0, 0, 0.1)")

        hover {
            property("background-color", "rgb(70, 130, 180)")
            property("color", "white")
        }
    }

    val sidebarItemSelected by style {
        self {
            property("background-color", "rgb(70, 130, 180)")
            property("color", "white")
            fontWeight("bold")
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

}
