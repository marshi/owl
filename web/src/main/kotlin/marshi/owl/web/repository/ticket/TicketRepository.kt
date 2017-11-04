package marshi.owl.web.repository.ticket

import marshi.owl.apiresponse.TicketListResponse
import marshi.owl.domain.entity.Ticket
import marshi.owl.web.repository.HttpApiTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.text.MessageFormat

@Repository
class TicketRepository(
    @Autowired private val httpApiTemplate: HttpApiTemplate
) {

    fun list(projectId: Long): List<Ticket> {
        val response = httpApiTemplate
            .resource(
                scheme = "http",
                host = "localhost",
                port = 8000,
                path = MessageFormat.format("/projects/{0}/tickets", projectId)
            ).get()
            .getEntity(TicketListResponse::class.java)
        return response.data
    }

    fun create(ticket: Ticket): Int {
        return httpApiTemplate
            .resource(
                scheme = "http",
                host = "localhost",
                port = 8000,
                path = MessageFormat.format("/projects/{0}/tickets", ticket.projectId)
            ).post(ticket)
            .statusCode
    }

}