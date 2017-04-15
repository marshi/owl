package marshi.owl.repository

import org.springframework.stereotype.Repository

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
class TicketRepository {

    fun create(projectId: Long, ticketId: Long) {
        println(""+ projectId + " "  + ticketId)
    }

}