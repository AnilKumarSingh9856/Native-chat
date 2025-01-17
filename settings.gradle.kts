@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()

    }
    plugins {
        id ("com.android.application") version "7.1.3"
        id ("com.android.library") version "7.1.3"
        id ("org.jetbrains.kotlin.android") version "1.7.20"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Native Chat"
include (":app")
 