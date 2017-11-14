package marshi.owl.domain.repository

import marshi.owl.domain.entity.Ticket
import java.util.*

interface TicketRepositoryInterface {
    fun create(ticket: Ticket)
    fun list(): List<Ticket>
    fun find(id: Long): Optional<Ticket>
}