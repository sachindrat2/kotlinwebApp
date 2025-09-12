package org.example.project

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.*

@Composable
fun HomePage() {
    Div({ classes(AppStylesheet.page) }) {

        // 🌟 Hero Section
        Div({ classes(AppStylesheet.hero) }) {
            H1 { Text("🚀 Build Modern Kotlin Web Apps") }
            P({ classes(AppStylesheet.heroText) }) {
                Text("Compose Web lets you create responsive, smooth, and animated apps for the future.")
            }
            A("#", { classes(AppStylesheet.ctaButton) }) { Text("Get Started") }
        }

        // ✨ Features Section (animated fade-in)
        Div({ classes(AppStylesheet.featuresSection) }) {
            H2({ classes(AppStylesheet.sectionTitle) }) { Text("Why Choose Kotlin Compose Web?") }

            Div({ classes(AppStylesheet.featureRow) }) {
                Feature("⚡ Fast", "Reactive and high-performance web apps with Kotlin.")
                Feature("📱 Responsive", "Your layout adapts beautifully to any device.")
                Feature("🌍 Cross-Platform", "Reuse code across Android, Desktop, and Web.")
            }
        }

        // 📖 About Section (slide-up animation)
        Div({ classes(AppStylesheet.aboutSection) }) {
            H2 { Text("About This App") }
            P { Text("This demo shows how Kotlin Compose Web can power a full-featured, modern website with animations and responsive design.") }
        }

        // 🎯 Call-to-Action Section
        Div({ classes(AppStylesheet.ctaSection) }) {
            H2 { Text("Ready to get started?") }
            A("#", { classes(AppStylesheet.ctaButton) }) { Text("Sign Up Now") }
        }
    }
}

@Composable
fun Feature(title: String, description: String) {
    Div({ classes(AppStylesheet.feature) }) {
        H3 { Text(title) }
        P { Text(description) }
    }
}
