package org.example.project.maguchilogic.pages

fun isExpired(expiry: String): Boolean {
    return try {
        val parts = expiry.split("-").map { it.toInt() }
        val year = parts[0]
        val month = parts[1] - 1 // JS Date months are 0-based
        val day = parts[2]
        val expiryDate = js("new Date(year, month, day)") as kotlin.js.Date
        val today = js("new Date()") as kotlin.js.Date
        expiryDate.getTime() < today.getTime()
    } catch (e: Exception) {
        false
    }
}
fun getJapaneseGreeting(): String {
    val hour = kotlin.js.Date().getHours() // returns 0..23

    return when (hour) {
        in 5..11 -> "おはようございます" // Morning
        in 12..17 -> "こんにちは"      // Afternoon
        else -> "こんばんは"           // Evening / Night
    }
}
