package com.weconnect.external.client.micro.service.models.services.clienteexterno

import com.weconnect.external.client.micro.service.models.entities.ClienteExterno
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

interface IClienteExternoService {

    @Transactional(readOnly = true)
    fun findAllClienteExterno(): List<ClienteExterno>

    @Transactional(readOnly = true)
    fun findClienteExternoByexternalClientIdentification(externalClientIdentification: String): ClienteExterno

    @Transactional(readOnly = true)
    fun findClienteExternoByexternalClientFirstName(externalClientFirstName: String): List<ClienteExterno>

    @Transactional(readOnly = false)
    fun saveClienteExterno(clienteExterno: ClienteExterno)

    @Transactional(readOnly = true)
    fun findClienteExternoByExternalClientID(externalClientID: Long): Optional<ClienteExterno>


}