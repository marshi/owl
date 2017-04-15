package marshi.owl.service

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

    fun create(projectId: Long, ticketId: Long) {
        ticketRepository.create(projectId, ticketId)
    }

}
