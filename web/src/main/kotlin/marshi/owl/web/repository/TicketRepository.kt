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
import java.net.URI

@Repository
class TicketRepository(
        @Autowired val httpClient: HttpClient,
        @Autowired val mapper: ObjectMapper
) {

    fun list(): List<Ticket> {
        val uri = URIBuilder()
                .setScheme("http")
                .setHost("localhost")
                .setPort(8000)
                .setPath("/tickets")
                .build()
        val execute = httpClient.execute(HttpGet(uri))
        val json = EntityUtils.toString(execute.entity)
        val response = mapper.readValue(json, TicketListResponse::class.java)
        return response.data
    }

}