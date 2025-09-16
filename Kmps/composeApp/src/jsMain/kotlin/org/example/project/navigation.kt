package org.example.project
import Page
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun Navigation(currentPage: Page, onNavigate: (Page) -> Unit) {
    var menuOpen by remember { mutableStateOf(false) }

    // Apply the stylesheet globally
    Style(AppStylesheet)
    Nav({ classes(AppStylesheet.navbar) }) {
        // Logo
        H1({ classes(AppStylesheet.logo) }) { Text("Maguchi DX") }
        // Desktop menu
        Ul({ classes(AppStylesheet.navList) }) {
            Page.values().forEach { page ->
                Li({
                    classes(AppStylesheet.navItem)
                    onClick { onNavigate(page); menuOpen = false }
                }) { Text(page.name) }
            }
        }

        // Hamburger for mobile
        Button({
            classes(AppStylesheet.hamburger)
            onClick { menuOpen = !menuOpen }
        }) { Text("☰") }
    }

    // Mobile drawer
    if (menuOpen) {
        Div({ classes(AppStylesheet.mobileMenu) }) {
            Page.entries.forEach { page ->
                Div({
                    classes(AppStylesheet.mobileNavItem)
                    onClick { onNavigate(page); menuOpen = false }
                }) { Text(page.name) }
            }
        }
    }
}
