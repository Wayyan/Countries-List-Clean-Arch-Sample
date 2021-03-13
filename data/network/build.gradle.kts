plugins {
    id ("com.android.library")
    id ("kotlin-android")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(BuildConfig.compileSdk)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        minSdkVersion(BuildConfig.minSdk)
        targetSdkVersion(BuildConfig.targetSdk)
        versionCode(BuildConfig.versionCode)
        versionName(BuildConfig.versionName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles( "consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = false
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(":data:framework")

    implementation(Kotlin.stdblib_jdk)
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.2.1")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")

    //Networking
    implementation(OkHttp.client)
    implementation(OkHttp.logger)
    testImplementation(OkHttp.mock_web_server)
    implementation(Retrofit.core)
    implementation(Retrofit.moshi_converter)

    //dagger
    daggerJvm()
}