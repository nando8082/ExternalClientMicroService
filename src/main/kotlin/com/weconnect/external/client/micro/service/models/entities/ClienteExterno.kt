package com.weconnect.external.client.micro.service.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity(name = "cliente_externo")
@Schema(
    name = "Cliente Externo",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UN " +
            "CLIENTE EXTERNO EN LA BASE DE DATOS"
)
class ClienteExterno : Serializable {

    @Id
    @TableGenerator(name="external_client_sequential_value", initialValue = 2307)
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
        generator = "external_client_sequential_value"
    )
    @Column(name = "id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADOR UNICO DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    var externalClientID: Long? = 0

    @NotEmpty(message = "EL CAMPO NO PUEDE ESTAR VACIO")
    @Column(name = "cedula", unique = true, nullable = false)
    @Schema(
        name = "cedula",
        description = "ES EL NUMERO DE CEDULA DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "0105338974",
        readOnly = true
    )
    var externalClientIdentification: String? = ""

    @NotEmpty(message = "EL CAMPO NO PUEDE ESTAR VACIO")
    @Column(name = "nombre", nullable = false)
    @Schema(
        name = "nombre",
        description = "ES EL NOMBRE DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "VANESSA MICHAEL",
        readOnly = true
    )
    var externalClientFirstName: String? = ""

    @Column(name = "apellido")
    @Schema(
        name = "apellido",
        description = "ES EL APELLIDO DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "BUSTAMANTE MENDOZA",
        readOnly = true
    )
    var externalClientLastName: String? = ""

    @Email
    @Column(name = "email", unique = true)
    @Schema(
        name = "email",
        description = "ES EL EMAIL DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "vanebustamen_23@hotmail.com",
        readOnly = true
    )
    var externalClientEmail: String? = ""

    @Column(name = "direccion")
    @Schema(
        name = "direccion",
        description = "ES LA DIRECCION DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "ARENAL RICAURTE",
        readOnly = true
    )
    var externalClientAddress: String? = ""

    @Column(name = "tipo_identificacion")
    @Schema(
        name = "tipo_identificacion",
        description = "ES EL TIPO DE IDENTIFICACION DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "04",
        readOnly = true
    )
    var externalClientIdentificationType: String? = ""

    @Column(name = "telefono")
    @Schema(
        name = "telefono",
        description = "ES EL TELEFONO DE CADA CLIENTE EXTERNO DENTRO DE LA BASE DE DATOS",
        example = "0998275721",
        readOnly = true
    )
    var externalClientPhoneNumber: String? = ""

    @Column(name = "id_company")
    @Schema(
        name = "compa??ia",
        description = "IDENTIFICADOR QUE HACE REFERENCIA A LA COMPANIA AL QUE PERTENECE UN CLIENTE EXTERNO",
        implementation = Driver::class,
        readOnly = true
    )
    var idCompany: Long? = 0
}