package com.weconnect.external.client.micro.service.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "person")
@Schema(
    name = "Persona",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UNA PERSONA " +
            "EN LA BASE DE DATOS")
class Person {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(name = "person_id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADOR UNICO DE CADA PERSONA DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    val personID: Long = 0

}