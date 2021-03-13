plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    //id("dagger.hilt.android.plugin")
    //id(KtLint.name)
    id("kotlin-android")
}

android {
    compileSdkVersion(BuildConfig.compileSdk)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.devduo.countries"
        minSdkVersion(BuildConfig.minSdk)
        targetSdkVersion(BuildConfig.targetSdk)
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildFeatures {
            viewBinding = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(":base"))

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    coreLibraryDesugaring(CommonLibs.desugar_lib)

    implementation(Kotlin.stdblib_jdk)
    implementation(KotlinCoroutine.android)

    //AndroidX
    implementation(AndroidXAppCompat.app_compat)
    implementation(AndroidXCore.core_ktx)
    implementation(AndroidXActivity.activity_ktx)
    implementation(AndroidXFragment.fragment_ktx)
    androidXArch()
    implementation(AndroidXRecyclerView.recycler_view)
    implementation(AndroidXPreference.preference_ktx)

    //Material
    implementation(Material.material)

    //Constraint Layout
    implementation(AndroidXConstraintLayout.constraint_layout)

    //Test
    testImplementation(CommonLibs.junit)
    mockito()
    mockitoAndroid()
    androidXTest()
    androidXEspresso()

    //dagger
    daggerJvm()
    daggerHilt()
    daggerHiltAndroidX()
    daggerAssistedInject()
}