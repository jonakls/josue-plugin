plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version ("8.1.1")
}

group = "top.jonakls"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("me.yushust.message:core:7.1.3")
    implementation("me.yushust.message:sourcetype-bukkit-yml:7.1.3")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    build {
        dependsOn("shadowJar")
    }

    shadowJar {
        archiveBaseName.set("JosuePlugin")
    }
}

tasks.test {
    useJUnitPlatform()
}