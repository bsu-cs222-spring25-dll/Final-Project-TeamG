plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "bsu.edu.cs222"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.slf4j:slf4j-nop:2.0.11")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")
    implementation("org.openjfx:javafx-controls:22")
    implementation("org.openjfx:javafx-fxml:22")
}
tasks.test {
    useJUnitPlatform()
}
javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}
application {
    mainClass.set("bsu.edu.cs222.menu.Main")
}