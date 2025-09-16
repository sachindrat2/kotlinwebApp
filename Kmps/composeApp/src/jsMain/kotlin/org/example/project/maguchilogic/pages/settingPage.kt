package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import org.example.project.AppStylesheet.className
import org.example.project.maguchilogic.pages.appstylesheetlogic.SettingsStylesheet
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.*

@Composable
fun SettingsPage(onLogout: () -> Unit, onBack: () -> Unit) {
    Style(SettingsStylesheet)

    var username by remember { mutableStateOf("John Doe") }
    var email by remember { mutableStateOf("john@example.com") }
    var password by remember { mutableStateOf("") }
    var notificationsEmail by remember { mutableStateOf(true) }
    var notificationsSMS by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }
    var language by remember { mutableStateOf("ja") }

    Div({ classes(SettingsStylesheet.content) }) {

        // Header
        Div({ classes(SettingsStylesheet.header) }) {
            Button({
                classes(SettingsStylesheet.backButton)
                onClick { onBack() }
            }) { Text("← Back") }
            H3 { Text("ユーザー設定 (User Settings)") }
        }

        // Profile
        Div({ classes(SettingsStylesheet.profileCard) }) {
            Img(src = "https://via.placeholder.com/80", attrs = { classes(SettingsStylesheet.profileImg) })
            Div {
                H4 { Text(username) }
                P { Text(email) }
            }
        }

        // Account
        Div({ classes(SettingsStylesheet.sectionCard) }) {
            H4 { Text("アカウント (Account)") }

            Div({ classes(SettingsStylesheet.inputContainer) }) {
                Label { Text("Username:") }
                Input(InputType.Text, attrs = {
                    value(username)
                    onInput { username = it.value }
                    classes(SettingsStylesheet.settingsInput)
                })
            }

            Div({ classes(SettingsStylesheet.inputContainer) }) {
                Label { Text("Email:") }
                Input(InputType.Email, attrs = {
                    value(email)
                    onInput { email = it.value }
                    classes(SettingsStylesheet.settingsInput)
                })
            }

            Div({ classes(SettingsStylesheet.inputContainer) }) {
                Label { Text("Password:") }
                Input(InputType.Password, attrs = {
                    value(password)
                    onInput { password = it.value }
                    classes(SettingsStylesheet.settingsInput)
                })
            }
        }

        // Notifications
        Div({ classes(SettingsStylesheet.sectionCard) }) {
            H4 { Text("通知 (Notifications)") }

            Div({ classes(SettingsStylesheet.checkboxContainer) }) {
                Input(InputType.Checkbox, attrs = {
                    checked(notificationsEmail)
                    onInput { notificationsEmail = it.target.checked }
                })
                Label({
                    className(SettingsStylesheet.checkboxLabel)
                }.toString()) {
                    Text("Email Notifications")
                }

            }

            Div({ classes(SettingsStylesheet.checkboxContainer) }) {
                Input(InputType.Checkbox, attrs = {
                    checked(notificationsSMS)
                    onInput { notificationsSMS = it.target.checked }
                })
                Label({
                    className(SettingsStylesheet.checkboxLabel)
                }.toString()) {
                    Text("SMS Notifications")
                }

            }
        }

        // Preferences
        Div({ classes(SettingsStylesheet.sectionCard) }) {
            H4 { Text("設定 (Preferences)") }

            Div({ classes(SettingsStylesheet.checkboxContainer) }) {
                Input(InputType.Checkbox, attrs = {
                    checked(darkMode)
                    onInput { darkMode = it.target.checked }
                })
                Label({
                    className(SettingsStylesheet.checkboxLabel)
                }.toString()) {
                    Text("Dark Mode")
                }

            }

            Div({ classes(SettingsStylesheet.inputContainer) }) {
                Label { Text("Language:") }
                Select(attrs = {
                    classes(SettingsStylesheet.settingsInput)
                    onInput { language = it.value.toString() }
                }) {
                    Option(attrs = { if (language == "ja") attr("selected", "true") }, value = "ja") { Text("日本語 (Japanese)") }
                    Option(attrs = { if (language == "en") attr("selected", "true") }, value = "en") { Text("English") }
                }
            }
        }

        // Danger Zone
        Div({ classes(SettingsStylesheet.dangerZone) }) {
            Button({ classes(SettingsStylesheet.deleteButton) }) { Text("Delete Account") }
            Button({
                classes(SettingsStylesheet.logoutButton)
                onClick { onLogout() }
            }) { Text("Logout") }
        }
    }
}
