plugins {
    id("comugamers.common-conventions")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":adapt:common"))
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.google.guava:guava:26.0-jre")
    implementation("com.github.luben:zstd-jni:1.4.1-1")
    implementation("com.github.tomas-langer:chalk:1.0.2")
}
