package ru.potatophobe.randomgrpc.service

import com.google.protobuf.Empty
import org.springframework.stereotype.Component
import ru.potatophobe.randomgrpc.IntValue
import ru.potatophobe.randomgrpc.RandomServiceGrpcKt
import ru.potatophobe.randomgrpc.Seed
import kotlin.random.Random

@Component
class RandomService : RandomServiceGrpcKt.RandomServiceCoroutineImplBase() {

    override suspend fun randomInt(request: Empty): IntValue {
        return IntValue.newBuilder().setValue(Random.nextInt()).build()
    }

    override suspend fun randomIntFromSeed(request: Seed): IntValue {
        return IntValue.newBuilder().setValue(Random(request.value).nextInt()).build()
    }
}