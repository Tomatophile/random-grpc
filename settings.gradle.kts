rootProject.name = "random-grpc"
include("api")
include("stub")
include("implementation")
include("client")

pluginManagement {
    plugins {
        kotlin("jvm") version "1.6.20"
        id("com.google.protobuf") version "0.8.18"
        id("org.springframework.boot") version "2.7.0"
        id("io.spring.dependency-management") version "1.0.11.RELEASE"
        kotlin("plugin.spring") version "1.6.20"
    }
}

val kotlinxCoroutinesVersion: String by settings
val grpcVersion: String by settings
val grpcKotlinVersion: String by settings
val googleProtobufVersion: String by settings

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("kotlinx") {
            library("coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
        }
        create("grpc") {
            library("stub", "io.grpc:grpc-stub:$grpcVersion")
            library("kotlin-stub", "io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
            library("protobuf", "io.grpc:grpc-protobuf:$grpcVersion")
            library("netty", "io.grpc:grpc-netty:$grpcVersion")
        }
        create("googleProtobuf") {
            library("java-util", "com.google.protobuf:protobuf-java-util:$googleProtobufVersion")
            library("kotlin", "com.google.protobuf:protobuf-kotlin:$googleProtobufVersion")
        }
    }
}