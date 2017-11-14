package marshi.owl.api.facade

import marshi.owl.domain.exception.TicketNotFound
import marshi.owl.apiresponse.ticket.TicketListResponse
import marshi.owl.domain.entity.Ticket
import marshi.owl.domain.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketFacade(
        @Autowired val ticketService: TicketService
) {

    @Transactional
    fun create(ticket: Ticket) {
        ticketService.create(ticket)
    }

    fun find(ticketId: Long): Ticket {
        return ticketService.findFromGraph(ticketId)
    }

//    fun nextStep(projectId: Long, ticketId: Long, nextTicket: NextStepTicketModel) {
//        ticketService.linkPathToNextStep(projectId, ticketId, nextTicket.convert())
//    }

    fun delete(ticketId: Long) {
        ticketService.delete(ticketId)
    }

    fun list(): TicketListResponse {
        val list = ticketService.list()
        return TicketListResponse(list, null)
    }

}