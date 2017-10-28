package marshi.owl.entity

import lombok.NoArgsConstructor
import lombok.Setter
import marshi.owl.datasource.graph.entity.TicketNode
import marshi.owl.datasource.rdb.entity.Ticket

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

    fun convertToNode(): TicketNode {
        val ticket = TicketNode(
                id,
                nextStepTickets?.map { it.convertToNode() }?.toSet()
        )
        return ticket
    }

    fun convertToRecord(): Ticket {
        val ticket = Ticket()
        ticket.id = id
        ticket.projectId = projectId
        ticket.title = title
        ticket.assigneeId = assigneeId
        ticket.content  = content
        return ticket
    }

    companion object {
        @JvmStatic
        fun convertFromNode(ticketNode: TicketNode): TicketModel {
            val ticketModel = TicketModel (
                    ticketNode.id
            )
            return ticketModel
        }

        @JvmStatic
        fun convertFromRecord(ticket: Ticket): TicketModel {
            val ticketModel = TicketModel (
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

