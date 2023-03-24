import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("comugamers.common-conventions")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    implementation(project(":api"))
    implementation("com.github.luben:zstd-jni:1.4.5-6")
    implementation("com.zaxxer:HikariCP:3.3.1")
    implementation("org.mongodb:mongo-java-driver:3.11.0-rc0")
    implementation("org.spongepowered:configurate-yaml:3.7-SNAPSHOT")
    implementation("org.bstats:bstats-bukkit:1.5")

    arrayOf("common", "v1_8_R3", "v1_9_R2",
            "v1_11_R1", "v1_12_R1", "v1_13_R2",
            "v1_14_R1", "v1_15_R1", "v1_16_R3"
    ).forEach {
        compileOnly(project(":adapt:$it"))
    }
}

tasks {
    named("build") {
        dependsOn(named("shadowJar"))
    }

    withType<ShadowJar> {
        archiveFileName.set("SlimeWorldManager.jar")
    }
}

bukkit {
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
    main = "com.grinderwolf.swm.plugin.SWMPlugin"
    apiVersion = "1.13"
    version = "${project.version}"
    authors = listOf("Grinderwolf", "Pabszito")
    description = "${findProperty("plugin-description")}"
    name = "${findProperty("plugin-name")}"

    commands {
        register("swm") {
            description = "Main SWM command."
            usage = "/swm <cmd>"
        }
    }
}