import androidx.compose.runtime.*
import org.example.dxteam.AboutPage
import org.example.dxteam.ContactPage
import org.example.dxteam.ProjectsPage
import org.example.project.AppStylesheet
import org.example.project.Footers
import org.example.project.HomePage
import org.example.project.Navigation
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div

enum class Page {
    HOME, ABOUT, PROJECTS, CONTACT
}

@Composable
fun WebApp() {
    // Track the current page
    var currentPage by remember { mutableStateOf(Page.HOME) }

    // Apply your CSS styles
    Style(AppStylesheet)

    Div(attrs = { classes(AppStylesheet.page) }) {
        // Navigation bar
        Navigation(currentPage) { selected ->
            currentPage = selected
        }

        // Page content with optional transition (experimental)
        Div(attrs = {
            classes(AppStylesheet.content)
        }) {
            when (currentPage) {
                Page.HOME -> HomePage()
                Page.ABOUT -> AboutPage()
                Page.PROJECTS -> ProjectsPage()
                Page.CONTACT -> ContactPage()
            }
        }

        // Footer
        Footers()
    }
}
