package org.example.project
import org.jetbrains.compose.web.renderComposable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import androidx.compose.runtime.*
import org.example.project.AppStylesheet.invoke
import org.jetbrains.compose.web.css.selectors.CSSSelector.PseudoClass.hover
import org.jetbrains.compose.web.dom.*

enum class Page {
    HOME, ABOUT, CONTACT
}

fun main() {
    renderComposable(rootElementId = "root") {
        Apps()
    }
}



@Composable
fun Apps() {
    var currentPage by remember { mutableStateOf(Page.HOME) }

    Style(AppStylesheet) // Apply global styles

    Div({ classes(AppStylesheet.page) }) {
        Navigation(currentPage) { selected -> // Navigation with page switching
            currentPage = selected
        }

        // Render current page content
        when (currentPage) {
            Page.HOME -> HomePage()
            Page.ABOUT -> AboutPage()
            Page.CONTACT -> ContactPage()
        }

        Footer() // Static footer
    }
}


@Composable
fun Navigation(currentPage: Page, onPageSelected: (Page) -> Unit) {
    Nav({ classes(AppStylesheet.nav) }) {
        val navItems = listOf(
            Page.HOME to "Home",
            Page.ABOUT to "About",
            Page.CONTACT to "Contact"
        )

        navItems.forEach { (page, label) ->
            A("#", {
                classes(AppStylesheet.navLink)
                onClick { onPageSelected(page) }
                style {
                    fontWeight(if (currentPage == page) "bold" else "normal")
                }
            }) { Text(label) }
        }
    }
}







