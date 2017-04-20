package marshi.owl.service

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
        @Autowired val ticketGraphRepository: TicketGraphRepository
) {

    fun create(ticketModel: TicketModel) {
        ticketGraphRepository.save(ticketModel.convertTo())
    }

    fun find(ticketId: Long): TicketModel {
        val ticket = ticketGraphRepository.findOne(ticketId)
        return TicketModel.convertFrom(ticket)
    }

    fun linkPathToNextStep(ticketId: Long, nextStepTicketModel: NextStepTicketModel) {
        val ticketModel = find(ticketId)
        val nextTicketModel = find(nextStepTicketModel.id!!)
        ticketModel.nextStepTickets = ticketModel.nextStepTickets?.plus(nextTicketModel)
        ticketGraphRepository.save(ticketModel.convertTo())
    }

}
