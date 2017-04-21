package marshi.owl.service

import marshi.owl.datasource.graph.entity.Path
import marshi.owl.datasource.graph.entity.Ticket
import marshi.owl.datasource.graph.repository.PathGraphRepository
import marshi.owl.entity.TicketModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import marshi.owl.datasource.graph.repository.TicketGraphRepository
import marshi.owl.datasource.rdb.repository.SequenceRepository
import marshi.owl.entity.NextStepTicketModel

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService(
        @Autowired val ticketGraphRepository: TicketGraphRepository,
        @Autowired val pathGraphRepository: PathGraphRepository
) {

    fun create(ticketModel: TicketModel) {
        ticketGraphRepository.save(ticketModel.convertTo())
    }

    fun find(ticketId: Long): TicketModel? {
        val ticket: Ticket? = ticketGraphRepository.findOne(ticketId)
        ticket ?: return null
        return TicketModel.convertFrom(ticket)
    }

    fun linkPathToNextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        val ticketModel = find(ticketId)
        ticketModel ?: return
        val nextTicketModel = find(nextStepTicketModel.id!!)
        nextTicketModel ?: return
        ticketModel.nextStepTickets = ticketModel.nextStepTickets?.plus(nextTicketModel)
        pathGraphRepository.save(Path(ticketModel.convertTo(), ticketModel.convertTo()))
    }

    fun  delete(ticketId: Long) {
        ticketGraphRepository.delete(ticketId)
    }

}
