package marshi.owl.web.view.ticket.list

import marshi.owl.web.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketListFacade(
        @Autowired private val ticketService: TicketService
) {

    fun list(): List<String> {
        return ticketService.list()
    }

}