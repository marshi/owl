package marshi.owl.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpClientConfiguration {

    @Bean
    fun httpClient(): HttpClient {
        return HttpClientBuilder
                .create()
                .build()
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy())
    }

}