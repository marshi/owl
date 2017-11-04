package marshi.owl.api.service

import marshi.owl.data.graph.repository.PathGraphRepository
import marshi.owl.domain.entity.Ticket
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathService(@Autowired val pathGraphRepository: PathGraphRepository) {

    fun create(prevTicket: Ticket, nextTicket: Ticket) {
        pathGraphRepository.save(prevTicket, nextTicket)
    }

}