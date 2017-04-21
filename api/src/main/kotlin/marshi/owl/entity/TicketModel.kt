package marshi.owl.entity

import lombok.NoArgsConstructor
import lombok.Setter
import marshi.owl.datasource.graph.entity.Ticket

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
        var assigneeId: Int? = null,
        var nextStepTickets: Set<TicketModel>? = mutableSetOf()
){

    fun convertTo(): Ticket {
        val ticket = Ticket(
                id,
                nextStepTickets?.map { it.convertTo() }?.toSet(),
                projectId,
                title,
                assigneeId,
                content
        )
        return ticket
    }

    companion object {
        @JvmStatic
        fun convertFrom(ticket: Ticket): TicketModel {
            val ticketModel = TicketModel(
                    ticket.id,
                    ticket.title,
                    ticket.content,
                    ticket.projectId,
                    ticket.assigneeId
            )
            return ticketModel
        }
    }


}

