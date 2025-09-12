package org.example.project

import android.os.Build

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Android"
}
