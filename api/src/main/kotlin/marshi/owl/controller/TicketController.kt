package marshi.owl.controller

import marshi.owl.TicketNotFound
import marshi.owl.apiresponse.TicketListResponse
import marshi.owl.entity.NextStepTicketModel
import marshi.owl.domain.entity.Ticket
import marshi.owl.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletResponse

/**
 *
 */
@RestController
@CrossOrigin(origins = arrayOf("http://localhost:8888"))
class TicketController(
        @Autowired val ticketFacade: TicketFacade
) {

    @RequestMapping(value = "/tickets", method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody ticket: Ticket) {
        ticketFacade.create(ticket)
        println("aiueo")
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.PATCH))
    fun depend(
            @PathVariable("ticketId") ticketId: Long,
            @RequestBody nextStepTicketModel: NextStepTicketModel
    ) {
        ticketFacade.nextStep(ticketId, nextStepTicketModel)
    }

    @RequestMapping(value = "/tickets", method = arrayOf(RequestMethod.GET))
    fun list(): TicketListResponse {
        return ticketFacade.list()
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.GET))
    fun get(response: HttpServletResponse, @PathVariable ticketId: Long): Ticket? {
        return try {
            ticketFacade.find(ticketId)
        } catch (e: TicketNotFound) {
            response.status = HttpStatus.NOT_FOUND.value()
            null
        }
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.DELETE))
    fun delete(response: HttpServletResponse, @PathVariable ticketId: Long) {
        return ticketFacade.delete(ticketId)
    }

}

