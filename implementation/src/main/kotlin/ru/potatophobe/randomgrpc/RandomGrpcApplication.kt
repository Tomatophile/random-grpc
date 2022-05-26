package ru.potatophobe.randomgrpc

import io.grpc.Server
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RandomGrpcApplication

val log: Logger = LoggerFactory.getLogger(RandomGrpcApplication::class.java)

fun main(args: Array<String>) {
    val applicationContext = runApplication<RandomGrpcApplication>(*args)
    runGrpcServer(applicationContext.getBean(Server::class.java))
}

fun runGrpcServer(server: Server) {
    server.start()
    log.info("Started gRPC server on port ${server.port}")
    server.awaitTermination()
}