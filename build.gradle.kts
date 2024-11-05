plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.allopen") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
    id("io.gatling.gradle") version "3.11.5.2"
}

group = "com.bhft"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    gatlingImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    gatlingImplementation("com.sksamuel.hoplite:hoplite-core:2.7.5")
    gatlingImplementation("com.sksamuel.hoplite:hoplite-yaml:2.7.5")
}

kotlin {
    jvmToolchain(17)
}
