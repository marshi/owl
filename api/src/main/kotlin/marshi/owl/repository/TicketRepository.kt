package marshi.owl.repository

import owl.datasource.entity.Ticket
import owl.datasource.entity.TicketExample
import owl.datasource.mapper.TicketMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
class TicketRepository {

    @Autowired
    private lateinit var ticketMapper: TicketMapper

    fun create(projectId: Long) {
        val ticket = Ticket()
        ticket.projectId = projectId
        val ticketId = ticketMapper.insertSelective(ticket)
        println(""+ projectId + " "  + ticketId)
    }

}