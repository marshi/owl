package marshi.owl.api.controller

import marshi.owl.domain.exception.TicketNotFound
import marshi.owl.api.entity.RequestPath
import marshi.owl.api.exception.InvalidParameterException
import marshi.owl.api.facade.PathFacade
import marshi.owl.domain.entity.Path
import marshi.owl.domain.exception.PathConflictException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 * Created by a13178 on 2017/04/21.
 */
@RestController
@RequestMapping(value = "/projects/{projectId}/paths")
class PathController(@Autowired val pathFacade: PathFacade) {

    @RequestMapping(method = [(RequestMethod.POST)])
    fun create(
        res: HttpServletResponse,
        @RequestBody requestPath: RequestPath,
        @PathVariable("projectId") projectId: Long
    ) {
        try {
            pathFacade.create(projectId, requestPath)
            res.status = HttpStatus.CREATED.value()
        } catch (e: InvalidParameterException) {
            res.status = HttpStatus.BAD_REQUEST.value()
        } catch (e: PathConflictException) {
            res.status = HttpStatus.CONFLICT.value()
        } catch (e: TicketNotFound) {
            res.status = HttpStatus.NOT_FOUND.value()
        }
    }

    @RequestMapping(method = [(RequestMethod.GET)])
    fun paths(
        res: HttpServletResponse,
        @PathVariable("projectId") projectId: Long
    ): List<Path> {
        val list = pathFacade.list(projectId)
        return list
    }

}

