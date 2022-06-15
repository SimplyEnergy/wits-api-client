repositories {
    mavenCentral()
    google()
}

plugins {
    // careful here, the plugins block explicitly isolated from the outer context, so needs it own vars
    val kotlinPluginVersion =  "1.6.20"
    val shadowVersion =  "7.1.0"

    idea
    kotlin("jvm") version kotlinPluginVersion
}

// Wrapper is optional, your local version should match, use sdkman to manage consistently
tasks.withType<Wrapper> {
    gradleVersion="7.4"
}

dependencies {
    val kotlinVersion =  "1.6.20"
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("com.squareup.moshi:moshi-adapters:1.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src/kt")
kotlin.sourceSets["test"].kotlin.srcDirs("test/kt")

sourceSets["main"].resources.srcDirs("src/resources")
sourceSets["test"].resources.srcDirs("test/resources")

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines = setOf("junit-jupiter")
    }
}
