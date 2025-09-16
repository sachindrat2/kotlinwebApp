package org.example.project

import WebApp
import org.example.project.maguchilogic.pages.MaguchiLogicApp
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        MaguchiLogicApp(

        )
    }
}

