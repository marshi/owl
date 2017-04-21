package marshi.owl.facade

import marshi.owl.TicketNotFound
import marshi.owl.datasource.graph.repository.TicketGraphRepository
import marshi.owl.entity.RequestPath
import marshi.owl.entity.TicketModel
import marshi.owl.service.PathService
import marshi.owl.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathFacade(@Autowired val ticketService: TicketService,
                 @Autowired val pathService: PathService
) {

    fun create(requestPath: RequestPath) {
        if (requestPath.prevTicketId == null || requestPath.nextTicketId == null) {
            return
        }
        val prev = ticketService.find(requestPath.prevTicketId!!)
        val next = ticketService.find(requestPath.nextTicketId!!)
        prev ?: throw TicketNotFound("ticket not found")
        next ?: throw TicketNotFound("ticket not found")
        pathService.create(prev, next)
    }

}

