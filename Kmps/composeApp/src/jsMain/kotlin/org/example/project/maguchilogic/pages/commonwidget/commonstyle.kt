import androidx.compose.runtime.Composable
import org.example.project.maguchilogic.pages.getLoggedInState
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun BackButton(onClick: () -> Unit) {
    Button({
        onClick { if (getLoggedInState()) onClick() }
        style {
            backgroundColor(rgb(33, 150, 243))
            color(rgb(255, 255, 255))

            borderRadius(8.px)
            padding(8.px, 16.px)
            cursor("pointer")
            property("border", "none")
            property("box-shadow", "0px 2px 4px rgba(0,0,0,0.1)")
            property("display", "flex")
            property("align-items", "center")
            property("gap", "8px")
        }
    }) {
        Span { Text("←") }
        Text("Back")
    }
}


