package marshi.owl

import marshi.owl.config.DatasourceInitializer
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = arrayOf("marshi.owl.data.graph"))
@EnableAutoConfiguration(exclude = arrayOf(
        DataSourceAutoConfiguration::class
))
class ApiApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplicationBuilder(ApiApplication::class.java)
                    .initializers(DatasourceInitializer())
                    .run(*args)
        }
    }
}
