package marshi.owl.api.facade

import marshi.owl.api.exception.TicketNotFound
import marshi.owl.apiresponse.TicketListResponse
import marshi.owl.api.entity.NextStepTicketModel
import marshi.owl.domain.entity.Ticket
import marshi.owl.api.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
        return ticketService.find(ticketId) ?: throw TicketNotFound("ticket not found")
    }

    fun nextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        ticketService.linkPathToNextStep(ticketId, nextStepTicketModel)
    }

    fun delete(ticketId: Long) {
        ticketService.delete(ticketId)
    }

    fun list(): TicketListResponse {
        val list = ticketService.list()
        return TicketListResponse(list, null)
    }

}