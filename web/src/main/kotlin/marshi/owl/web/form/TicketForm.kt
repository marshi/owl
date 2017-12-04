package marshi.owl.web.form

import marshi.owl.domain.entity.Ticket

class TicketForm(
    val title: String?,
    val content: String?,
    val projectId: Long,
    val assigneeId: Int?
) {

    fun convertTo(): Ticket {
        return Ticket(
            title = this.title,
            content = this.content,
            projectId = this.projectId,
            assigneeId = this.assigneeId
        )
    }



}



