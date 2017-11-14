package marshi.owl.domain.repository

import marshi.owl.domain.entity.Path
import marshi.owl.domain.entity.Ticket

interface PathGraphRepositoryInterface {
    fun save(ticket: Ticket, nextTicket: Ticket): Path
}