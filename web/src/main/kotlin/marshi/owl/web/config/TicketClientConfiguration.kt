package marshi.owl.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import marshi.owl.web.repository.HttpApiTemplate
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TicketClientConfiguration {

    @Bean
    fun httpApiTemplate(): HttpApiTemplate {
        return HttpApiTemplate(
                mapper = objectMapper(),
                httpClient = HttpClientBuilder
                        .create()
                        .build()
        )
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy())
    }

}