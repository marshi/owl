package marshi.owl.config

import org.mybatis.spring.annotation.MapperScan
import org.neo4j.ogm.session.SessionFactory
import org.neo4j.ogm.session.event.EventListener
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by a13178 on 2017/04/15.
 */
@Configuration
@MapperScan("marshi.owl.datasource")
@EnableConfigurationProperties(Neo4jProperties::class)
class OwlAppConfiguration {

//    @Bean
//    fun transactionManager(): Neo4jTransactionManager {
//        return Neo4jTransactionManager()
//    }

    @Bean
	fun  configuration(properties: Neo4jProperties): org.neo4j.ogm.config.Configuration {
		return properties.createConfiguration()
	}

    @Bean
    fun sessionFactory(configuration: org.neo4j.ogm.config.Configuration,
                       applicationContext: ApplicationContext,
                       eventListeners: ObjectProvider<List<EventListener>> ): SessionFactory {
        val sessionFactory: SessionFactory  = SessionFactory(configuration, "marshi.owl.datasource.graph")
//        val providedEventListeners: List<EventListener>  = eventListeners.ifAvailable
//        for (eventListener: EventListener in providedEventListeners) {
//            sessionFactory.register(eventListener)
//        }
        return sessionFactory
    }

}
