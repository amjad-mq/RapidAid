plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.amjad.rapidaid"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.amjad.rapidaid"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // ----------------------------------------------------------------
    // Core Android Libraries
    // ----------------------------------------------------------------
    implementation(libs.androidx.core.ktx)                 // Kotlin extensions for Android core APIs
    implementation(libs.androidx.lifecycle.runtime.ktx)   // Lifecycle-aware components with coroutine support
    implementation(libs.androidx.activity.compose)        // Integration of Jetpack Compose with Activity lifecycle

    // ----------------------------------------------------------------
    // Jetpack Compose UI Libraries
    // ----------------------------------------------------------------
    implementation(platform(libs.androidx.compose.bom))         // Compose Bill of Materials (BOM) for version alignment
    implementation(libs.androidx.compose.ui)                   // Core UI elements for Compose (Text, Column, Row, etc.)
    implementation(libs.androidx.compose.ui.graphics)          // Graphics and drawing support for Compose
    implementation(libs.androidx.compose.ui.tooling.preview)   // Preview Composables within Android Studio
    implementation(libs.androidx.compose.material3)            // Material Design 3 UI components (Buttons, Cards, etc.)

    // ----------------------------------------------------------------
    // Unit Testing Libraries
    // ----------------------------------------------------------------
    testImplementation(libs.junit)                              // Standard unit testing framework

    // ----------------------------------------------------------------
    // Instrumentation / UI Testing Libraries
    // ----------------------------------------------------------------
    androidTestImplementation(libs.androidx.junit)             // Android-specific JUnit integration
    androidTestImplementation(libs.androidx.espresso.core)     // UI automation testing (Espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM alignment for instrumentation tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4) // Compose UI testing with JUnit4

    // ----------------------------------------------------------------
    // Debugging & Development Tools
    // ----------------------------------------------------------------
    debugImplementation(libs.androidx.compose.ui.tooling)      // UI tooling for debugging and inspection
    debugImplementation(libs.androidx.compose.ui.test.manifest) // Manifest support for Compose UI tests
}