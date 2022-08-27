plugins {
    id("java")
}

group = "network.geode"
version = "1.0-SNAPSHOT"

val relocateLoc = "network.geode.libs"

val jetbrainsAnnotations = "23.0.0"
val junitJupiterApiVer = "5.9.0"
val junitJupiterEngineVer = "5.9.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:$jetbrainsAnnotations")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterApiVer")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterEngineVer")
}

tasks {
    test {
        useJUnitPlatform()
    }
}