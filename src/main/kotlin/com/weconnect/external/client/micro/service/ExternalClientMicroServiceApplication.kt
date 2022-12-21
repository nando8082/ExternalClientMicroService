package com.weconnect.external.client.micro.service

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(
	info = Info(
		title = "MICROSERVICIOS DE CLIENTES EXTERNOS",
		description = "",
		contact = Contact(
			name = "DANIEL PINARGO",
			email = "dpinargo@est.ups.edu.ec"
		),

		),
	servers = [
		Server(
			url = "https://mibusetabackend.com:8091/externalclient",
			description = "SERVIDOR DE PRODUCCION"
		)
	]

)
class ExternalClientMicroServiceApplication

fun main(args: Array<String>) {
	runApplication<ExternalClientMicroServiceApplication>(*args)
}
