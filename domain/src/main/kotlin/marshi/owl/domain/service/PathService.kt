package marshi.owl.domain.service

import marshi.owl.domain.entity.Ticket
import marshi.owl.domain.repository.PathGraphRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathService(
    @Autowired private val pathGraphRepository: PathGraphRepositoryInterface
) {

    fun create(prevTicket: Ticket, nextTicket: Ticket) {
        pathGraphRepository.save(prevTicket, nextTicket)
    }

}