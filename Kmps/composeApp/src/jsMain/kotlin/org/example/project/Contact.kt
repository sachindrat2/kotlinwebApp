package org.example.project

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactPage() {
    Div({ classes(AppStylesheet.content) }) {
        H2 { Text("Contact Us") }
        P { Text("You can reach us at contact@example.com") }
        P { Text("Or follow us on social media for updates.") }
    }
}