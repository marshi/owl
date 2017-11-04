package marshi.owl.api.facade

import marshi.owl.api.exception.TicketNotFound
import marshi.owl.api.entity.RequestPath
import marshi.owl.api.service.PathService
import marshi.owl.api.service.TicketService
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

