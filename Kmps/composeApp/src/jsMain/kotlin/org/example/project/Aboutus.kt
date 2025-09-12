package org.example.project

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
@Composable
fun AboutPage() {
    Div({ classes(AppStylesheet.content) }) {
        H2 { Text("About Us") }
        P { Text("This page gives information about the app and its purpose.") }
        P { Text("Built with Kotlin Compose Web, fully responsive!") }
    }
}
