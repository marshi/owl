package marshi.owl.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import marshi.owl.web.repository.HttpApiTemplate
import marshi.owl.web.repository.project.ProjectRepository
import marshi.owl.web.repository.ticket.TicketRepository
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OwlApiConfiguration {

    @Bean
    fun ticketRepository (
        @Autowired mapper: ObjectMapper
    ): TicketRepository {
        return TicketRepository(
            HttpApiTemplate(
                mapper = mapper,
                httpClient = HttpClientBuilder
                    .create()
                    .build(),
                scheme = "http",
                host = "localhost",
                port = 8000
            )
        )
    }

    @Bean
    fun projectRepository (
        @Autowired mapper: ObjectMapper
    ): ProjectRepository {
        return ProjectRepository(
            HttpApiTemplate(
                mapper = mapper,
                httpClient = HttpClientBuilder
                    .create()
                    .build(),
                scheme = "http",
                host = "localhost",
                port = 8000
            )
        )
    }

}