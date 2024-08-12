// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}

buildscript {
    dependencies {
        classpath(libs.github.dcendents)
//        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
        classpath(libs.gradle)
//        classpath("com.android.tools.build:gradle:8.4.2")
//        classpath("com.android.application:com.android.application.gradle.plugin:8.4.2")
//        classpath("com.android.library:com.android.library.gradle.plugin:8.4.2")
    }
}