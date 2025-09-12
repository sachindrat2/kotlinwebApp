package org.example.project

import platform.UIKit.UIDevice



actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "iOS"
}
