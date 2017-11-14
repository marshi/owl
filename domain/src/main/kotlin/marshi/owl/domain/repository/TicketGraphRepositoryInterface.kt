package marshi.owl.domain.repository

import marshi.owl.domain.entity.Ticket
import java.util.*

interface TicketGraphRepositoryInterface {
    fun findById(ticketId: Long, i: Int): Optional<Ticket>
    fun deleteById(ticketId: Long)
}