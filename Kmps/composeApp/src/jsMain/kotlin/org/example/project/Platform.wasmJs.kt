package org.example.project


actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "JS Browser"
}
