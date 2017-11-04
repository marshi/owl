package marshi.owl.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import marshi.owl.web.repository.HttpApiTemplate
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TicketClientConfiguration {

    @Bean
    fun httpApiTemplate(
        @Autowired mapper: ObjectMapper
    ): HttpApiTemplate {
        return HttpApiTemplate(
            mapper = mapper,
            httpClient = HttpClientBuilder
                .create()
                .build(),
            scheme = "http",
            host = "localhost",
            port = 8000
        )
    }

}