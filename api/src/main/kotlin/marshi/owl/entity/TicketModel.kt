package marshi.owl.entity

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import owl.datasource.entity.Ticket

/**
 * Created by a13178 on 2017/04/17.
 */
@NoArgsConstructor
@Setter
class TicketModel(
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var projectId: Long? = null,
    var assigneeId: Int? = null
){

    fun convertTo(): Ticket {
        val ticket = Ticket()
        ticket.id = id
        ticket.title = title
        ticket.content = content
        ticket.assigneeId = assigneeId
        ticket.projectId = projectId
        return ticket
    }

}