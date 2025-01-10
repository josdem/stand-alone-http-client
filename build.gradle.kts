plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "com.josdem.http.client"
version = "1.0-SNAPSHOT"

application {
    mainClass = "com.josdem.http.client.MainKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

