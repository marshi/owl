package marshi.owl.domain.repository

import marshi.owl.domain.entity.Ticket

interface TicketRepositoryInterface {
    fun create(ticket: Ticket)
    fun list(): List<Ticket>
}