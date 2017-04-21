package marshi.owl.controller

import marshi.owl.TicketNotFound
import marshi.owl.entity.RequestPath
import marshi.owl.facade.PathFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
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

