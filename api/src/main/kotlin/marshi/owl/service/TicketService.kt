package marshi.owl.service

import marshi.owl.entity.TicketModel
import marshi.owl.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService {

    @Autowired
    lateinit var ticketRepository: TicketRepository

    fun create(projectId: Long, ticketModel: TicketModel) {
        ticketRepository.create(projectId, ticketModel)
    }

}
