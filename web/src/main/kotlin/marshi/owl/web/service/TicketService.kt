package marshi.owl.web.service

import marshi.owl.web.repository.TicketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketService(
        @Autowired private val ticketRepository: TicketRepository
) {

    fun list(): List<> {
        return listOf("aiueo", "aiue")
    }

}