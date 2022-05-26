group = "ru.potatophobe.random-grpc"
version = parent!!.version

plugins {
    `java-library`
}

java {
    sourceSets.getByName("main").resources.srcDir("src/main/proto")
}