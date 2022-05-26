group = "ru.potatophobe.random-grpc"
version = parent!!.version

plugins {
    idea
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(project(":stub"))

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))

    runtimeOnly(grpc.netty)

    testImplementation(kotlin("test"))
}

tasks.compileKotlin {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
}