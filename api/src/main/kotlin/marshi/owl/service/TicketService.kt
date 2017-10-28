package marshi.owl.service

import marshi.owl.datasource.graph.entity.Path
import marshi.owl.datasource.graph.entity.TicketNode
import marshi.owl.datasource.graph.repository.PathGraphRepository
import marshi.owl.entity.TicketModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import marshi.owl.datasource.graph.repository.TicketGraphRepository
import marshi.owl.datasource.rdb.repository.SequenceRepository
import marshi.owl.datasource.rdb.repository.TicketRepository
import marshi.owl.entity.NextStepTicketModel

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService(
        @Autowired val ticketGraphRepository: TicketGraphRepository,
        @Autowired val pathGraphRepository: PathGraphRepository,
        @Autowired val ticketRepository: TicketRepository
) {

    fun create(ticketModel: TicketModel) {
        ticketRepository.create(ticketModel)
    }

//    fun create(ticketModel: TicketModel) {
//        ticketGraphRepository.save(ticketModel.convertToNode())
//    }

    fun find(ticketId: Long): TicketModel? {
        val ticketNode: TicketNode? = ticketGraphRepository.findOne(ticketId)
        ticketNode ?: return null
        return TicketModel.convertFromNode(ticketNode)
    }

    fun linkPathToNextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        val ticketModel = find(ticketId)
        ticketModel ?: return
        val nextTicketModel = find(nextStepTicketModel.id!!)
        nextTicketModel ?: return
        ticketModel.nextStepTickets = ticketModel.nextStepTickets?.plus(nextTicketModel)
        pathGraphRepository.save(Path(ticketModel.convertToNode(), ticketModel.convertToNode()))
    }

    fun  delete(ticketId: Long) {
        ticketGraphRepository.delete(ticketId)
    }

    fun list(): List<TicketModel> {
        return ticketRepository.list()
    }

}
