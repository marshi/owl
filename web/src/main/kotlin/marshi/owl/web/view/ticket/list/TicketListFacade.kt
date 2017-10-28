package marshi.owl.web.view.ticket.list

import service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView

@Service
class TicketListFacade(
        @Autowired private val ticketService: TicketService
) {

    fun list(): ModelAndView {
        val modelAndView = ModelAndView("test")
        val list = ticketService.list()
        modelAndView.addObject("list", list)
        return modelAndView
    }

}