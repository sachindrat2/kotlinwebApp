plugins {
    kotlin("multiplatform") version "1.9.10" apply false
    id("org.jetbrains.compose") version "1.5.1" apply false
    id("com.android.application") version "8.3.0" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
