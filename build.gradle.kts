plugins {
    id("java")
    id("maven-publish")
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "network.geode"
            artifactId = "Nap"
            version = "1.0"

            from(components["java"])
        }
    }
}