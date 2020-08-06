plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "tm.mr.simplemusicplayer"
        minSdkVersion(15)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    androidExtensions {
        isExperimental = true
    }

    dynamicFeatures = mutableSetOf(":feature_home", ":feature_favorite")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(":library_base"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    api("androidx.constraintlayout:constraintlayout:1.1.3")


    api("com.google.dagger:dagger:2.24")
    api("com.google.dagger:dagger-android:2.24")
    api("com.google.dagger:dagger-android-support:2.24")
    api("com.google.dagger:hilt-android:2.28-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")
    kapt("com.google.dagger:dagger-android-processor:2.23.2")
    kapt("com.google.dagger:dagger-compiler:2.28")

    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.nav_version}")
    api("androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}")
    api("com.squareup.retrofit2:converter-gson:2.7.2")
    api("com.squareup.okhttp3:logging-interceptor:4.7.2")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.6.3")
    api("io.reactivex.rxjava2:rxkotlin:2.2.0")
    api("io.reactivex.rxjava2:rxandroid:2.0.2")


    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

}