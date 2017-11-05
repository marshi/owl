package marshi.owl.web.repository.ticket

import marshi.owl.apiresponse.ticket.TicketListResponse
import marshi.owl.domain.entity.Ticket
import marshi.owl.web.repository.HttpApiTemplate
import java.text.MessageFormat

class TicketRepository(
    private val httpApiTemplate: HttpApiTemplate
) {

    fun list(projectId: Long): List<Ticket> {
        val response = httpApiTemplate
            .resource(MessageFormat.format("/projects/{0}/tickets", projectId))
            .get()
            .getEntity(TicketListResponse::class.java)
        return response.data
    }

    fun create(ticket: Ticket): Int {
        return httpApiTemplate
            .resource(
                MessageFormat.format("/projects/{0}/tickets", ticket.projectId)
            ).post(ticket)
            .statusCode
    }

}