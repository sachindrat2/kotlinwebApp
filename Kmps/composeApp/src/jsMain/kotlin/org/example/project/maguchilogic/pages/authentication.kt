package org.example.project.maguchilogic.pages

import org.w3c.dom.get
import org.w3c.dom.set
import kotlinx.browser.window

fun saveLoggedInState(isLoggedIn: Boolean) {
    window.localStorage["isLoggedIn"] = isLoggedIn.toString()
}

fun getLoggedInState(): Boolean {
    return window.localStorage["isLoggedIn"]?.toBoolean() ?: false
}
fun confirmLogout(): Boolean {
    return window.confirm("Are you sure you want to logout?")
}
