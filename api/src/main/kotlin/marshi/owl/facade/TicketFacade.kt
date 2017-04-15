package marshi.owl.facade

import marshi.owl.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketFacade {

    @Autowired
    lateinit var ticketService: TicketService

    fun create(projectId: Long, ticketId: Long) {
        ticketService.create(projectId, ticketId)
    }

}