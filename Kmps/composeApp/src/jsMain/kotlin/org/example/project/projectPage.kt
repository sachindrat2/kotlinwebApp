package org.example.dxteam

import androidx.compose.runtime.Composable
import org.example.project.AppStylesheet
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectsPage() {
    Div({
        style {
            padding(120.px, 24.px, 40.px, 24.px) // offset navbar
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            backgroundColor(rgb(245, 246, 250)) // light gray background
            color(rgb(30, 30, 30))
        }
    }) {
        H2({
            style {
                fontSize(28.px)
                fontWeight("bold")
                marginBottom(24.px)
                textAlign("center")
            }
        }) { Text("Our Key Projects") }

        // Cards Container
        Div({
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                justifyContent(JustifyContent.Center)
                gap(24.px)
            }
        }) {
            // Project 1
            ProjectCard(
                title = "Enterprise Data Integration",
                description = "Seamlessly integrate and manage enterprise data from multiple sources.",
                emoji = "📊"
            )

            // Project 2
            ProjectCard(
                title = "AI-driven Process Automation",
                description = "Automate workflows and improve efficiency using AI solutions.",
                emoji = "🤖"
            )

            // Project 3
            ProjectCard(
                title = "Smart Warehouse & Logistics",
                description = "Optimize supply chain and warehouse management with smart technology.",
                emoji = "📦"
            )

            // Project 4
            ProjectCard(
                title = "Enterprise Security & Compliance",
                description = "Ensure secure operations and compliance with regulations.",
                emoji = "🛡️"
            )
        }
    }
}

@Composable
fun ProjectCard(title: String, description: String, emoji: String) {
    Div({ classes(AppStylesheet.projectCard) }) {
        H3({ classes(AppStylesheet.projectCardTitle) }) {
            Text("$emoji $title")
        }
        P({ classes(AppStylesheet.projectCardDescription) }) {
            Text(description)
        }
    }
}

