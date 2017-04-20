package marshi.owl.controller

import marshi.owl.entity.NextStepTicketModel
import marshi.owl.entity.TicketModel
import marshi.owl.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
    fun get(@PathVariable ticketId: Long): TicketModel {
        return ticketFacade.find(ticketId)
    }

}

