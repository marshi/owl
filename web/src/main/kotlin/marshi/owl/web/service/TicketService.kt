package marshi.owl.web.service

import marshi.owl.domain.entity.Ticket
import marshi.owl.web.repository.project.ProjectRepository
import marshi.owl.web.repository.ticket.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketService(
    @Autowired private val ticketRepository: TicketRepository
) {

    fun list(): List<Ticket> {
        return ticketRepository.list()
    }

}