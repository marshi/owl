package marshi.owl.web.view.ticket.register

import marshi.owl.web.form.TicketForm
import marshi.owl.web.repository.ticket.TicketRepository
import marshi.owl.web.view.ticket.list.TicketListFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class TicketRegisterController(
    @Autowired private val ticketRegisterFacade: TicketRegisterFacade,
    @Autowired private val ticketRepository: TicketRepository
) {

    @RequestMapping(value = "/ticket/register", method = arrayOf(RequestMethod.GET))
    fun registerInput(
        @ModelAttribute("ticket") ticketForm: TicketForm
    ): ModelAndView {
        return ticketRegisterFacade.registerForm()
    }

    @RequestMapping(value = "/ticket/register", method = arrayOf(RequestMethod.POST))
    fun register(
        @ModelAttribute("ticket") ticketForm: TicketForm
    ): ModelAndView {
        ticketRepository.create(ticketForm.convertTo())
        return ModelAndView("redirect:/ticket/list")
    }

}