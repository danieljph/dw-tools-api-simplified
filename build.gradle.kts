plugins {
    java
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.karyasarma"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    implementation("com.fasterxml.jackson.core:jackson-core:2.13.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")

    implementation("org.bouncycastle:bcprov-ext-debug-jdk15to18:1.68")
    implementation("commons-codec:commons-codec:1.15")
    implementation("commons-io:commons-io:2.8.0")

    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

springBoot {
    mainClass.set("com.karyasarma.dw_tools_api.AppKt")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xjsr305=strict"
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar>().configureEach {
    launchScript()
}
