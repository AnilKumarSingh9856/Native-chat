// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
   
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.google.services)
    }
}

plugins {
    id("com.android.application") version "8.6.0" apply false
    id("com.android.library") version "8.6.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("com.google.dagger.hilt.android") version "2.42" apply false
    alias(libs.plugins.google.gms.google.services) apply false
}


