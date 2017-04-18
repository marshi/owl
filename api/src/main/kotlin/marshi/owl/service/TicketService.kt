package marshi.owl.service

import marshi.owl.entity.TicketModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import marshi.owl.datasource.graph.repository.TicketGraphRepository

/**
 * Created by a13178 on 2017/04/15.
 */
@Service
class TicketService(
        @Autowired val ticketGraphRepository: TicketGraphRepository
) {

    fun create(projectId: Long, ticketModel: TicketModel) {
        ticketGraphRepository.save(ticketModel.convertTo())
    }

    fun find(projectId: Long, ticketId: Long): TicketModel {
        val ticket = ticketGraphRepository.findOne(ticketId)
        return TicketModel.convertFrom(ticket)
    }

}
