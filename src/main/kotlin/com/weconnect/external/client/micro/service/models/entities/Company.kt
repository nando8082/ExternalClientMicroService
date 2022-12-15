package com.weconnect.external.client.micro.service.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*

@Entity(name = "company")
@Schema(
    name = "Compañia",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UNA COMPAÑIA " +
            "EN LA BASE DE DATOS")

class Company : Serializable {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(name = "co_id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADOR UNICO DE CADA COMPAÑIA DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    val companyID: Long = 0

}