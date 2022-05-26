package ru.potatophobe.randomgrpc

import com.google.protobuf.Empty
import io.grpc.ManagedChannelBuilder
import kotlin.random.Random

suspend fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build()
    val randomService = RandomServiceGrpcKt.RandomServiceCoroutineStub(channel)

    println("Random int: ${randomService.randomInt(Empty.getDefaultInstance()).value}")
    println("Random int from seed: ${randomService.randomIntFromSeed(Seed.newBuilder().setValue(Random.nextLong()).build()).value}")
}