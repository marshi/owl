package marshi.owl.api

import marshi.owl.api.config.DatasourceInitializer
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = arrayOf("marshi.owl.data.graph"))
@MapperScan(basePackages = arrayOf("marshi.owl.data.rdb.mapper"))
@EnableAutoConfiguration(exclude = arrayOf(
        DataSourceAutoConfiguration::class
))
@ComponentScan("marshi.owl")
class ApiApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplicationBuilder(ApiApplication::class.java)
                    .initializers(DatasourceInitializer())
                    .run(*args)
        }
    }
}
