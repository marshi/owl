package marshi.owl.datasource.rdb.repository

import marshi.owl.entity.TicketModel
import marshi.owl.datasource.rdb.mapper.TicketMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
class TicketRepository(
        @Autowired val ticketMapper: TicketMapper
) {

////    fun create(projectId: Long, ticketModel: TicketModel) {
////        val ticket = ticketModel.convertTo()
////        ticket.projectId = projectId
////        ticketMapper.insertSelective(ticket)
//    }

}