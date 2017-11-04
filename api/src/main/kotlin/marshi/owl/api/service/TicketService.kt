package marshi.owl.api.service

import marshi.owl.data.repository.PathGraphRepository
import marshi.owl.data.repository.TicketGraphRepository
import marshi.owl.data.repository.TicketRepository
import marshi.owl.domain.entity.Ticket
import marshi.owl.api.entity.NextStepTicketModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService(
    @Autowired val ticketGraphRepository: TicketGraphRepository,
    @Autowired val pathGraphRepository: PathGraphRepository,
    @Autowired val ticketRepository: TicketRepository
) {

    fun create(ticket: Ticket) {
        ticketRepository.create(ticket)
    }

//    fun create(ticketModel: TicketModel) {
//        ticketGraphRepository.save(ticketModel.convertToNode())
//    }

    fun find(ticketId: Long): Ticket? {
        return ticketGraphRepository.findById(
                ticketId,
                1
        ).orElse(null)
    }

    fun linkPathToNextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        val ticket = find(ticketId)
        ticket ?: return
        val nextTicketModel = find(nextStepTicketModel.id!!)
        nextTicketModel ?: return
        ticket.nextStepTickets = ticket.nextStepTickets?.plus(nextTicketModel)
        pathGraphRepository.save(ticket, nextTicketModel)
    }

    fun  delete(ticketId: Long) {
        ticketGraphRepository.deleteById(ticketId)
    }

    fun list(): List<Ticket> {
        return ticketRepository.list()
    }

}
