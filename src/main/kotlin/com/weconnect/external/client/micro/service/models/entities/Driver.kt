package com.weconnect.external.client.micro.service.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*

@Entity(name = "driver")
@Schema(
    name = "Conductor",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UN CONDUCTOR " +
            "EN LA BASE DE DATOS")
class Driver : Serializable{

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(name = "dr_id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADOR UNICO DE CADA CONDUUCTOR DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    val driverId: Long = 0

}