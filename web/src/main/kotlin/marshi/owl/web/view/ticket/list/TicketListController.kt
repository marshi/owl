package marshi.owl.web.view.ticket.list

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class TicketListController(
        @Autowired private val ticketFacade: TicketListFacade
) {

    @RequestMapping(value = "/test", method = arrayOf(RequestMethod.GET))
    fun test(): ModelAndView {
        return ticketFacade.list()
    }

}