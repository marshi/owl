package marshi.owl.service

import marshi.owl.datasource.graph.entity.Path
import marshi.owl.datasource.graph.repository.PathGraphRepository
import marshi.owl.entity.TicketModel
import org.aspectj.weaver.tools.cache.SimpleCacheFactory.path
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by a13178 on 2017/04/21.
 */
@Service
class PathService(@Autowired val pathGraphRepository: PathGraphRepository) {

    fun create(prevTicketModel: TicketModel, nextTicketModel: TicketModel) {
        val path = Path(prevTicketModel.convertTo(), nextTicketModel.convertTo())
        pathGraphRepository.save(path)
    }

}