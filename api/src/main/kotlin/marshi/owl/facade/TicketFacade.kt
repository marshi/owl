package marshi.owl.facade

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

    fun create(ticketModel: TicketModel) {
        ticketService.create(ticketModel)
    }

    fun find(ticketId: Long): TicketModel {
        return ticketService.find(ticketId)
    }

    fun  nextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        ticketService.linkPathToNextStep(ticketId, nextStepTicketModel)
    }

}