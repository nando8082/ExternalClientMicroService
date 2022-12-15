package com.weconnect.external.client.micro.service.models.dao

import com.weconnect.external.client.micro.service.models.entities.ClienteExterno
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface IClienteExternoDAO : CrudRepository<ClienteExterno, Long> {


    fun findClienteExternoByexternalClientIdentification(externalClientIdentification: String): ClienteExterno

    fun findClienteExternoByexternalClientFirstName(externalClientFirstName: String): List<ClienteExterno>

//    fun findClienteExternoByID(externalClientID: Long): Optional<ClienteExterno>

}