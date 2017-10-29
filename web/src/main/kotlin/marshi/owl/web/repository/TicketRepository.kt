package marshi.owl.web.repository

import com.fasterxml.jackson.databind.ObjectMapper
import marshi.owl.apiresponse.TicketListResponse
import marshi.owl.domain.entity.Ticket
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.util.EntityUtils
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

}