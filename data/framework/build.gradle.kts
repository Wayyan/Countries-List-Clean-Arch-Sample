plugins {
    id ("java-library")
    id ("kotlin")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    implementation(Kotlin.stdblib_jdk)
    api(KotlinCoroutine.core)
    implementation(CommonLibs.javaxInject)

    //dagger
    daggerJvm()
}