package marshi.owl.api.controller

import marshi.owl.api.exception.TicketNotFound
import marshi.owl.apiresponse.ticket.TicketListResponse
import marshi.owl.api.entity.NextStepTicketModel
import marshi.owl.domain.entity.Ticket
import marshi.owl.api.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 *
 */
@RestController
@CrossOrigin(origins = arrayOf("http://localhost:8888"))
@RequestMapping(value = "/projects/{projectId}/tickets")
class TicketController(
    @Autowired val ticketFacade: TicketFacade
) {

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(
        @PathVariable("projectId") projectId: Long,
        @RequestBody ticket: Ticket
    ) {
        ticketFacade.create(ticket)
    }

    @RequestMapping(value = "/{ticketId}", method = arrayOf(RequestMethod.PATCH))
    fun depend(
        @PathVariable("projectId") projectId: Long,
        @PathVariable("ticketId") ticketId: Long,
        @RequestBody nextStepTicketModel: NextStepTicketModel
    ) {
        ticketFacade.nextStep(ticketId, nextStepTicketModel)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun list(
        @PathVariable("projectId") projectId: Long
    ): TicketListResponse {
        return ticketFacade.list()
    }

    @RequestMapping(value = "/{ticketId}", method = arrayOf(RequestMethod.GET))
    fun get(
        @PathVariable("projectId") projectId: Long,
        @PathVariable ticketId: Long,
        response: HttpServletResponse
    ): Ticket? {
        return try {
            ticketFacade.find(ticketId)
        } catch (e: TicketNotFound) {
            response.status = HttpStatus.NOT_FOUND.value()
            null
        }
    }

    @RequestMapping(value = "/{ticketId}", method = arrayOf(RequestMethod.DELETE))
    fun delete(
        @PathVariable("projectId") projectId: Long,
        @PathVariable ticketId: Long,
        response: HttpServletResponse) {
        return ticketFacade.delete(ticketId)
    }

}

