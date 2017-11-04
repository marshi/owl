package marshi.owl.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpClientConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy())
    }

}