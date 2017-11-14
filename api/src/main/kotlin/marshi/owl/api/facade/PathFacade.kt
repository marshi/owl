package marshi.owl.api.facade

import marshi.owl.api.entity.RequestPath
import marshi.owl.api.exception.InvalidParameterException
import marshi.owl.domain.exception.PathConflictException
import marshi.owl.domain.service.PathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathFacade(
    @Autowired val pathService: PathService
) {

    fun create(projectId: Long, requestPath: RequestPath) {
        if (!requestPath.isValid()) {
            throw InvalidParameterException()
        }
        pathService.create(
            projectId,
            requestPath.prevTicketId!!,
            requestPath.nextTicketId!!
        )
    }

}

