package marshi.owl.domain.service

import marshi.owl.domain.entity.Ticket
import marshi.owl.domain.repository.PathGraphRepositoryInterface
import marshi.owl.domain.repository.TicketGraphRepositoryInterface
import marshi.owl.domain.repository.TicketRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService(
    @Autowired private val ticketGraphRepository: TicketGraphRepositoryInterface,
    @Autowired private val pathGraphRepository: PathGraphRepositoryInterface,
    @Autowired private val ticketRepository: TicketRepositoryInterface
) {

    fun create(ticket: Ticket) {
        ticketRepository.create(ticket)
    }

    fun find(ticketId: Long): Ticket? {
        return ticketGraphRepository.findById(
                ticketId,
                1
        ).orElse(null)
    }

    fun linkPathToNextStep(ticketId: Long, nextTicket: Ticket) {
        val ticket = find(ticketId)
        ticket ?: return
        val nextTicketModel = find(nextTicket.id!!)
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
