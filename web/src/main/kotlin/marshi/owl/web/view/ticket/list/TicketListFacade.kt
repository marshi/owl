package marshi.owl.web.view.ticket.list

import marshi.owl.web.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView

@Service
class TicketListFacade(
        @Autowired private val ticketService: TicketService
) {

    fun list(
        projectId: Long
    ): ModelAndView {
        val modelAndView = ModelAndView("ticket_list")
        val tickets = ticketService.list(projectId)
        modelAndView.addObject("tickets", tickets)
        return modelAndView
    }

}