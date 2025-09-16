package org.example.project.maguchilogic.pages.appstylesheetlogic

import org.jetbrains.compose.web.css.*


object SettingsStylesheet : StyleSheet() {

    val content by style {
        property("max-width", "600px")
        property("margin", "0 auto")
        property("padding", "24px")
        property("font-family", "Arial, sans-serif")
    }

    val header by style {
        property("display", "flex")
        property("align-items", "center")
        property("justify-content", "space-between")
        property("margin-bottom", "24px")
    }

    val backButton by style {
        property("padding", "8px 16px")
        property("border-radius", "8px")
        property("border", "0px solid transparent")
        property("background-color", "rgb(200, 200, 200)")
        property("cursor", "pointer")
        hover { property("background-color", "rgb(180, 180, 180)") }
    }

    val sectionCard by style {
        property("background-color", "rgb(250, 250, 250)")
        property("padding", "16px")
        property("border-radius", "12px")
        property("margin-bottom", "24px")
        property("box-shadow", "0px 1px 3px rgba(0,0,0,0.03)")
    }

    val profileCard by style {
        property("display", "flex")
        property("align-items", "center")
        property("background-color", "rgb(245, 245, 245)")
        property("padding", "16px")
        property("border-radius", "12px")
        property("margin-bottom", "24px")
        property("box-shadow", "0px 2px 6px rgba(0,0,0,0.05)")
    }

    val profileImg by style {
        property("border-radius", "50%")
        property("margin-right", "16px")
    }

    val settingsInput by style {
        property("width", "100%")
        property("padding", "8px")
        property("border", "1px solid rgb(220, 220, 220)")
        property("border-radius", "8px")
        property("outline", "none")
        focus { property("border-color", "rgb(100, 149, 237)") }
    }

    val inputContainer by style {
        property("margin-top", "12px")
    }

    val inputContainerSmall by style {
        property("margin-top", "8px")
    }

    val checkboxContainer by style {
        property("display", "flex")
        property("align-items", "center")
        property("margin-top", "8px")
    }

    val checkboxLabel by style {
        property("margin-left", "8px")
    }

    val dangerZone by style {
        property("margin-top", "32px")
        property("border-top", "1px solid rgb(220,220,220)")
        property("padding-top", "16px")
        property("display", "flex")
    }

    val deleteButton by style {
        property("background-color", "rgb(255, 100, 100)")
        property("color", "white")
        property("padding", "8px 16px")
        property("border", "0px solid transparent")
        property("border-radius", "8px")
        property("cursor", "pointer")
        hover { property("background-color", "rgb(220, 60, 60)") }
    }

    val logoutButton by style {
        property("padding", "8px 16px")
        property("border-radius", "8px")
        property("cursor", "pointer")
        property("background-color", "rgb(100, 149, 237)")
        property("color", "white")
        property("border", "0px solid transparent")
        property("margin-left", "16px")
        hover { property("background-color", "rgb(70, 120, 210)") }
    }
}
