package org.example.project

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.css.*

@Composable
fun AboutPage() {
    Style(AppStylesheet) // Apply stylesheet

    Div({ classes(AppStylesheet.aboutContainer) }) {
        H2({ classes(AppStylesheet.aboutTitle) }) {
            Text("About the DX Team")
        }

        P({ classes(AppStylesheet.aboutText) }) {
            Text(
                "The DX Team at Maguchi Group focuses on building modern enterprise-grade applications, " +
                        "optimizing workflows, and enabling smarter decision-making with data-driven solutions. " +
                        "Our expertise includes AI, automation, cloud integration, and secure enterprise software development."
            )
        }

        Div({ classes(AppStylesheet.cardContainer) }) {
            // Card 1
            Div({ classes(AppStylesheet.card) }) {
                H3({ classes(AppStylesheet.cardTitle) }) { Text("Innovation") }
                P({ classes(AppStylesheet.cardText) }) { Text("We create solutions that transform enterprise processes and efficiency.") }
            }

            // Card 2
            Div({ classes(AppStylesheet.card) }) {
                H3({ classes(AppStylesheet.cardTitle) }) { Text("Expertise") }
                P({ classes(AppStylesheet.cardText) }) { Text("AI, automation, cloud integration, and secure enterprise software.") }
            }

            // Card 3
            Div({ classes(AppStylesheet.card) }) {
                H3({ classes(AppStylesheet.cardTitle) }) { Text("Collaboration") }
                P({ classes(AppStylesheet.cardText) }) { Text("We work closely with clients to deliver scalable enterprise solutions.") }
            }
        }
    }
}
