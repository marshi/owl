package marshi.owl.domain.service

import marshi.owl.domain.entity.Ticket
import marshi.owl.domain.exception.TicketNotFound
import marshi.owl.domain.repository.PathGraphRepositoryInterface
import marshi.owl.domain.repository.TicketGraphRepositoryInterface
import marshi.owl.domain.repository.TicketRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.MessageFormat
import java.util.*

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

    fun findOptionalFromGraph(ticketId: Long): Optional<Ticket> {
        return ticketGraphRepository.findById(
            ticketId,
            1
        )
    }

    fun findFromGraph(ticketId: Long): Ticket {
        return findOptionalFromGraph(ticketId)
            .orElseThrow{
                TicketNotFound(
                    message = MessageFormat.format("ticketId = {0}", ticketId))
            }
    }

    fun findOptionalRecord(ticketId: Long): Optional<Ticket> {
        return ticketRepository.find(ticketId)
    }

    fun findRecord(ticketId: Long): Ticket {
        return findOptionalRecord(ticketId)
            .orElseThrow{
                TicketNotFound(
                    message = MessageFormat.format("ticketId = {0}", ticketId))
            }
    }

    fun existRecord(ticketId: Long): Boolean {
        return findOptionalRecord(ticketId).isPresent
    }

//    fun linkPathToNextStep(projectId: Long, ticketId: Long, nextTicket: Ticket) {
//        val ticket = find(ticketId)
//        ticket ?: return
//        val nextTicketModel = find(nextTicket.id!!)
//        nextTicketModel ?: return
//        ticket.nextStepTickets = ticket.nextStepTickets?.plus(nextTicketModel)
//        pathGraphRepository.save(ticket, nextTicketModel)
//    }

    fun delete(ticketId: Long) {
        ticketGraphRepository.deleteById(ticketId)
    }

    fun list(): List<Ticket> {
        return ticketRepository.list()
    }

    fun update(ticketId: Long, ticket: Ticket) {
        ticketRepository.update(ticketId, ticket)
    }

}
