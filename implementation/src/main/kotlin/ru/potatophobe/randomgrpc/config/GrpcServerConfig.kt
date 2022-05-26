package ru.potatophobe.randomgrpc.config

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ServerProperties::class)
class GrpcServerConfig(
    private val serverProperties: ServerProperties,
    private val services: List<BindableService>
) {
    @Bean
    fun grpcServer(): Server {
        return ServerBuilder
            .forPort(serverProperties.port ?: 8080)
            .apply { services.forEach { addService(it) } }
            .build()
    }
}