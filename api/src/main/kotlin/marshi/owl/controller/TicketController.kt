package marshi.owl.controller

import marshi.owl.facade.TicketFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.sql.DataSource

/**
 *
 */
@RestController
class TicketController {

    @Autowired
    lateinit var ticketFacade: TicketFacade

    @RequestMapping(value = "/projects/{projectId}/tickets", method = arrayOf(RequestMethod.POST))
    fun create(@PathVariable projectId: Long) {
        ticketFacade.create(projectId)
    }

    @RequestMapping(value = "/hello", method = arrayOf(RequestMethod.GET))
    fun get() {
        println("aiueo")
    }

}