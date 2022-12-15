package com.weconnect.external.client.micro.service.controllers

import com.weconnect.external.client.micro.service.StaticValues
import com.weconnect.external.client.micro.service.models.entities.ClienteExterno
import com.weconnect.external.client.micro.service.models.services.clienteexterno.IClienteExternoService
import com.weconnect.external.client.micro.service.models.services.validations.IValidationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional
import javax.validation.Valid

@RestController
@RequestMapping("/externalclientController")
@Tag(
    name = "CONTROLADOR DE CLIENTE EXTERNO",
    description = "ESTE MICROSERVICIO CONTROLA TODAS LA PETICIONES QUE SE REALIZARAN A LA BASE DE DATOS DENTRO DE LA TABLA DE CLIENTE EXTERNO"
)
class ClienteExternoController {

    @Autowired
    private val iClienteExternoService: IClienteExternoService? = null

    @Autowired
    private val iValidationService: IValidationService? = null

    @GetMapping("/findExternalClientByIdentification/{externalClientIdentification}")
    @Operation(
        summary = "LISTAR CLIENTES EXTERNOS POR NÚMERO DE CÉDULA",
        description = "ESTE SERVICIO SE ENCARGA DE LISTAR TODOS LOS CLIENTES EXTERNOS QUE POSEEN" +
                "CIERTO NUMERO DE CEDULA, SI EL RESULTADO DE LA BUSQUEDA ES CORRECTA RETORNARA" +
                "UNA LISTA DE CLIENTES EXTERNOS, CASO CONTRARIO NO LISTARA NADA",
        method = "GET",
        parameters = [Parameter(
            name = "externalClientIdentification",
            description = "IDENTIFICADOR UNICO DE UN CLIENTE EXTERNO",
            required = true
        )]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "SI LA CÉDULA DEL CLIENTE EXTERNO ES CORRECTO DEVOLVERA LOS PRODUCTOS EXISTENTES EN LA BASE DE DATOS",
                content = [
                    (Content(
                        mediaType = "application/json",
                        schema = Schema(
                            allOf = arrayOf(ClienteExterno::class)
                        )
                    ))
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE LA CEDULA DEL CLIENTE EXTERNO NO EXISTA EN LA BASE DE DATOS"
            ),
            ApiResponse(
                responseCode = "500",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EXISTA UN  ERROR INTERNO DEL SERVIDOR"
            )
        ]
    )
    fun findExternalClientByIdentification(
        @PathVariable("externalClientIdentification") externalClientIdentification: String,
    ): Any {
        val response = HashMap<String, Any>()
        return try {
            val clienteExternoList = iClienteExternoService!!.findClienteExternoByexternalClientIdentification(
                externalClientIdentification = externalClientIdentification
            )
            run {
                response["message"] = StaticValues.MESSAGE_SUCCESS_FIND
                response["response"] = clienteExternoList
                ResponseEntity<Map<*, *>>(response, HttpStatus.OK)
            }
        } catch (e: DataAccessException) {
            iValidationService!!.getExceptionMessage(e)
        }
    }


    @GetMapping("/findExternalClientByName/{externalClientFirstName}")
    @Operation(
        summary = "LISTAR CLIENTES EXTERNOS POR NOMBRE",
        description = "ESTE SERVICIO SE ENCARGA DE LISTAR TODOS LOS CLIENTES EXTERNOS QUE POSEEN" +
                "CIERTO NOMBRE, SI EL RESULTADO DE LA BUSQUEDA ES CORRECTA RETORNARA" +
                "UNA LISTA DE CLIENTES EXTERNOS, CASO CONTRARIO NO LISTARA NADA",
        method = "GET",
        parameters = [Parameter(
            name = "externalClientFirstName",
            description = "IDENTIFICADOR UNICO DE UN CLIENTE EXTERNO",
            required = true
        )]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "SI EL NOMBRE DEL CLIENTE EXTERNO ES CORRECTO DEVOLVERA LOS PRODUCTOS EXISTENTES EN LA BASE DE DATOS",
                content = [
                    (Content(
                        mediaType = "application/json",
                        schema = Schema(
                            allOf = arrayOf(ClienteExterno::class)
                        )
                    ))
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EL NOMBRE DEL CLIENTE EXTERNO NO EXISTA EN LA BASE DE DATOS"
            ),
            ApiResponse(
                responseCode = "500",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EXISTA UN  ERROR INTERNO DEL SERVIDOR"
            )
        ]
    )
    fun findExternalClientByName(
        @PathVariable("externalClientFirstName") externalClientFirstName: String,
    ): Any {
        val response = HashMap<String, Any>()
        return try {
            val clienteExternoList = iClienteExternoService!!.findClienteExternoByexternalClientFirstName(
                externalClientFirstName = externalClientFirstName
            )
            run {
                response["message"] = StaticValues.MESSAGE_SUCCESS_FIND
                response["response"] = clienteExternoList
                ResponseEntity<Map<*, *>>(response, HttpStatus.OK)
            }
        } catch (e: DataAccessException) {
            iValidationService!!.getExceptionMessage(e)
        }
    }

    @PostMapping("/createExternalClient")
    @Operation(
        summary = "CREAR UN NUEVO CLIENTE EXTERNO",
        description = "ESTE SERVICIO SE ENCARGA DE CREAR NUEVOS CLIENTES EXTERNOS EN LA BASE DE DATOS",
        method = "POST",
        parameters = [Parameter(
            name = "externalClientID" +
                    "externalClientIdentification" +
                    "externalClientFirstName" +
                    "externalClientLastName" +
                    "externalClientEmail" +
                    "externalClientAddress" +
                    "externalClientIdentificationType" +
                    "externalClientPhoneNumber" +
                    "idCompany",
            description = "PARAMETROS QUE POSEEN LOS OBJETOS DE TIPO CLIENTE EXTERNO",
            required = true
        )]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "SI LOS DATOS INGRESADOS SON CORRECTOS SE CREARA UN NUEVO CLIENTE EXTERNO EN LA BASE DE DATOS",
                content = [
                    (Content(
                        mediaType = "application/json",
                        schema = Schema(
                            allOf = arrayOf(ClienteExterno::class)
                        )
                    ))
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE LOS DATOS INGRESADOS SEAN INCORRECTOS"
            ),
            ApiResponse(
                responseCode = "500",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EXISTA UN ERROR INTERNO DEL SERVIDOR"
            )
        ]
    )
    fun saveExternalClient(
        @Valid @RequestBody clienteExterno: ClienteExterno, result: BindingResult
    ): Any {
        val response = HashMap<String, Any>()
        return try {
            //val Optional<ClienteExterno> clienteOpcional = Optional.ofNullable(iClienteExternoService!!.findClienteExternoByexternalClientIdentification(clienteExterno.externalClientIdentification)
            val newClienteExterno = iClienteExternoService!!.saveClienteExterno(
                clienteExterno = clienteExterno
            )
            run {
                response["message"] = StaticValues.MESSAGE_SUCCESS_SAVE
                response["response"] = clienteExterno
                ResponseEntity<Map<*, *>>(response, HttpStatus.OK)
            }
        } catch (e: DataAccessException) {
            iValidationService!!.getExceptionMessage(e)
        }
    }



}