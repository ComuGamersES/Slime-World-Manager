plugins {
    id("comugamers.common-conventions")
    `maven-publish`
}

val version = project.version.toString()

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "${project.name}"
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "comugamers"
            credentials(PasswordCredentials::class)

            if (version.contains("-SNAPSHOT")) {
                url = uri("https://repo.comugamers.com/repository/maven-snapshots/")
            } else {
                url = uri("https://repo.comugamers.com/repository/maven-releases/")
            }
        }
    }
}