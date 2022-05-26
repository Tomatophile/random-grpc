import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ru.potatophobe.random-grpc"
version = parent!!.version

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
}

dependencies {
    api(kotlin("stdlib"))

    api(kotlinx.coroutines.core)
    api(grpc.stub)
    api(grpc.kotlin.stub)
    api(grpc.protobuf)
    api(googleProtobuf.java.util)
    api(googleProtobuf.kotlin)

    protobuf(project(":api"))
}

val grpcVersion: String by parent!!
val grpcKotlinVersion: String by parent!!
val googleProtobufVersion: String by parent!!

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$googleProtobufVersion"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKotlinVersion:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}