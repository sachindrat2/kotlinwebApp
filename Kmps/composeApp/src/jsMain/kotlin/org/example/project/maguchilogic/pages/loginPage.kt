package org.example.project.maguchilogic.pages

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import org.example.project.maguchilogic.pages.appstylesheetlogic.AppStylesheet
import org.example.project.maguchilogic.pages.appstylesheetlogic.LoginStylesheet
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder

@Composable
fun LoginPage(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    Style(LoginStylesheet)

    Div({ classes(LoginStylesheet.page) }) {
        Div({ classes(LoginStylesheet.loginCard) }) {

            Img(src = "/images/appIcon.png", attrs = { classes(LoginStylesheet.appIcon) })




            if (error != null) {
                Div({ classes(LoginStylesheet.errorText) }) { Text(error!!) }
            }

            Input(type = InputType.Text, attrs = {
                placeholder("Username")
                value(username)
                onInput { username = it.value }
                classes(LoginStylesheet.loginInput)
            })

            Div({
                style { position(Position.Relative); width(100.percent); marginBottom(20.px) }
            }) {
                Input(type = if (showPassword) InputType.Text else InputType.Password, attrs = {
                    placeholder("Password")
                    value(password)
                    onInput { password = it.value }
                    classes(LoginStylesheet.loginInput)
                })

                Button({
                    classes(LoginStylesheet.toggleButton)
                    onClick { showPassword = !showPassword }
                }) { Text(if (showPassword) "Hide" else "Show") }
            }

            Button({
                classes(LoginStylesheet.loginButton)
                onClick {
                    if (username == "admin" && password == "admin123") {
                        onLoginSuccess()
                    } else {
                        error = "Invalid credentials"
                    }
                }
            }) { Text("Login") }
        }
    }
}

