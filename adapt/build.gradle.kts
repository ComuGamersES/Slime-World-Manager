subprojects {
    subprojects {
        apply(plugin = "comugamers.common-conventions")
    }

    dependencies {
        compileOnly(project(":api"))
        compileOnly(project(":classmodifier"))
    }
}