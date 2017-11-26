package marshi.owl.domain.repository

import marshi.owl.domain.entity.Path
import marshi.owl.domain.entity.Ticket
import java.util.*

interface PathGraphRepositoryInterface {
    fun save(projectId: Long, ticket: Ticket, nextTicket: Ticket): Path
    fun findBy(prevTicketId: Long, nextTicketId: Long): Optional<Path>
    fun list(projectId: Long): List<Path>
}