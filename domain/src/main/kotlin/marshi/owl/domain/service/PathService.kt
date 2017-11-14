package marshi.owl.domain.service

import marshi.owl.domain.entity.Ticket
import marshi.owl.domain.exception.PathConflictException
import marshi.owl.domain.exception.TicketNotFound
import marshi.owl.domain.repository.PathGraphRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.MessageFormat

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathService(
    @Autowired private val pathGraphRepository: PathGraphRepositoryInterface,
    @Autowired private val ticketService: TicketService
) {
    fun create(projectId: Long, prevTicketId: Long, nextTicketId: Long) {
        val path = pathGraphRepository.findBy(prevTicketId, nextTicketId)
        path.ifPresent {
            throw PathConflictException("")
        }
        if (!ticketService.existRecord(prevTicketId) ||
            !ticketService.existRecord(nextTicketId)) {
            throw TicketNotFound()
        }
        val prev = ticketService.findOptionalFromGraph(prevTicketId)
            .orElse(Ticket(id = prevTicketId))
        val next = ticketService.findOptionalFromGraph(nextTicketId)
            .orElse(Ticket(id = nextTicketId))
        pathGraphRepository.save(projectId, prev, next)
    }

}