package marshi.owl.web.repository.ticket

import marshi.owl.apiresponse.TicketListResponse
import marshi.owl.domain.entity.Ticket
import marshi.owl.web.repository.HttpApiTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TicketRepository(
    @Autowired private val httpApiTemplate: HttpApiTemplate
) {

    fun list(): List<Ticket> {
        val response = httpApiTemplate
            .resource(
                scheme = "http",
                host = "localhost",
                port = 8000,
                path = "/tickets"
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
                path = "/tickets"
            ).post(ticket)
            .statusCode
    }

}