package com.weconnect.external.client.micro.service.models.services.clienteexterno

import com.weconnect.external.client.micro.service.models.dao.IClienteExternoDAO
import com.weconnect.external.client.micro.service.models.entities.ClienteExterno
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class ClienteExternoServiceImpl : IClienteExternoService {

    @Autowired
    private val iClienteExternoDAO: IClienteExternoDAO? = null

    override fun findAllClienteExterno(): List<ClienteExterno> {
        return iClienteExternoDAO!!.findAll() as List<ClienteExterno>
    }

    override fun findClienteExternoByexternalClientIdentification(externalClientIdentification: String): ClienteExterno {
        return iClienteExternoDAO!!.findClienteExternoByexternalClientIdentification(externalClientIdentification = externalClientIdentification)
    }

    override fun findClienteExternoByexternalClientFirstName(externalClientFirstName: String): List<ClienteExterno> {
        return iClienteExternoDAO!!.findClienteExternoByexternalClientFirstName(externalClientFirstName = externalClientFirstName)
    }

    override fun saveClienteExterno(clienteExterno: ClienteExterno) {
        iClienteExternoDAO!!.save(clienteExterno)
    }

//    override fun findClienteExternobyID(externalClientID: Long): Optional<ClienteExterno> {
//        return iClienteExternoDAO!!.findClienteExternoByID(externalClientID = externalClientID)
//    }


}