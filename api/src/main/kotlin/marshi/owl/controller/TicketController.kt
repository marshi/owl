package marshi.owl.controller

import marshi.owl.TicketNotFound
import marshi.owl.entity.NextStepTicketModel
import marshi.owl.entity.TicketModel
import marshi.owl.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 *
 */
@RestController
class TicketController(
        @Autowired val ticketFacade: TicketFacade
) {

    @RequestMapping(value = "/tickets", method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody ticketModel: TicketModel) {
        ticketFacade.create(ticketModel)
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.PATCH))
    fun depend(
            @PathVariable("ticketId") ticketId: Long,
            @RequestBody nextStepTicketModel: NextStepTicketModel
    ) {
        ticketFacade.nextStep(ticketId, nextStepTicketModel)
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.GET))
    fun get(response: HttpServletResponse, @PathVariable ticketId: Long): TicketModel? {
        try {
            return ticketFacade.find(ticketId)
        } catch (e: TicketNotFound) {
            response.status = HttpStatus.NOT_FOUND.value()
            return null
        }
    }

    @RequestMapping(value = "/tickets/{ticketId}", method = arrayOf(RequestMethod.DELETE))
    fun delete(response: HttpServletResponse, @PathVariable ticketId: Long) {
        return ticketFacade.delete(ticketId)
    }

}

