package marshi.owl.api.controller

import marshi.owl.api.exception.TicketNotFound
import marshi.owl.api.entity.RequestPath
import marshi.owl.api.facade.PathFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 * Created by a13178 on 2017/04/21.
 */
@RestController
class PathController(@Autowired val pathFacade: PathFacade) {

    @RequestMapping(value = "/paths", method = arrayOf(RequestMethod.POST))
    fun create(res: HttpServletResponse, @RequestBody requestPath: RequestPath) {
        try {
            pathFacade.create(requestPath)
        } catch (e: TicketNotFound) {
            res.status = HttpStatus.NOT_FOUND.value()
        }
    }



}

