plugins {
    id("java")
}

group = "network.geode"
version = "1.0-SNAPSHOT"

val jetbrainsAnnotations = "23.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:$jetbrainsAnnotations")
}
