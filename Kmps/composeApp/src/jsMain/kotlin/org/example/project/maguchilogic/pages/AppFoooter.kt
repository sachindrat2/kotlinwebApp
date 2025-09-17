import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.project.maguchilogic.pages.getJapaneseGreeting
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun AppFooter(version: String = "v1.0.0") {
    Div({
        style {
            width(100.percent)
            property("padding", "4px 12px")// reduce vertical padding
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            backgroundColor(rgb(240, 240, 240))
            color(rgb(80, 80, 80))
            fontSize(11.px)                   // slightly smaller font
            fontFamily("Arial, sans-serif")
            position(Position.Fixed)
            bottom(0.px)
            boxSizing("border-box")           // ensures padding doesn’t expand height too much
        }
    }) {
        Text("© ${js("new Date().getFullYear()")} Maguchi Logistics. Version 1.0.0")
    }
}

@Composable
fun GreetingHeader() {
    val greeting = remember { getJapaneseGreeting() }

    H2({
        style {
            color(Color("#2E8B57"))          // dark green
            fontSize(24.px)                  // adjust font size to fit
            fontWeight("bold")
            margin(16.px)
            whiteSpace("nowrap")             // keep in one line
            overflow("hidden")               // hide overflow if text is long
            property("text-overflow", "ellipsis")         // show "..." if text overflows
        }
    }) {
        Text("$greeting,")
        Text("Welcome to the Maguchi Logistics!")
    }
}


@Composable
fun ShimmerBox(width: CSSLengthValue, height: CSSLengthValue, styleModifier: StyleBuilder.() -> Unit = {}) {
    Div({
        style {
            this.width(width)
            this.height(height)
            borderRadius(4.px)
            backgroundColor(rgb(50, 50, 50))
            property("overflow", "hidden")
            position(Position.Relative)
            property(
                "background",
                "linear-gradient(90deg, rgba(70,70,70,0.8) 25%, rgba(100,100,100,0.8) 50%, rgba(70,70,70,0.8) 75%)"
            )
            property("background-size", "200% 100%")
            property("animation", "shimmer 1.5s linear infinite")
            styleModifier()
        }
    }) {}
}



