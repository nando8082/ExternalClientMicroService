package com.weconnect.external.client.micro.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExternalClientMicroServiceApplication

fun main(args: Array<String>) {
	runApplication<ExternalClientMicroServiceApplication>(*args)
}
