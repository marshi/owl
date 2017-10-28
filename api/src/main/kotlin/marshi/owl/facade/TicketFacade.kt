package marshi.owl.facade

import marshi.owl.TicketNotFound
import marshi.owl.entity.NextStepTicketModel
import marshi.owl.entity.TicketModel
import marshi.owl.service.TicketService
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
    fun create(ticketModel: TicketModel) {
        ticketService.create(ticketModel)
    }

    fun find(ticketId: Long): TicketModel {
        return ticketService.find(ticketId) ?: throw TicketNotFound("ticket not found")
    }

    fun nextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        ticketService.linkPathToNextStep(ticketId, nextStepTicketModel)
    }

    fun delete(ticketId: Long) {
        ticketService.delete(ticketId)
    }

    fun list(): List<TicketModel> {
        return ticketService.list()
    }

}