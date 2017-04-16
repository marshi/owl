package marshi.owl.controller

import marshi.owl.entity.TicketModel
import marshi.owl.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*
import javax.sql.DataSource

/**
 *
 */
@RestController
class TicketController(
        @Autowired val ticketFacade: TicketFacade
) {

    @RequestMapping(value = "/projects/{projectId}/tickets", method = arrayOf(RequestMethod.POST))
    fun create(@PathVariable projectId: Long, @RequestBody ticketModel: TicketModel) {
        ticketFacade.create(projectId, ticketModel)
    }

    @RequestMapping(value = "/hello", method = arrayOf(RequestMethod.GET))
    fun get() {
        println("aiueo")
    }

}