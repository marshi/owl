package marshi.owl.config

import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.bind.RelaxedPropertyResolver
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import owl.datasource.RoutingDataSource
import java.text.MessageFormat

/**
 * Created by a13178 on 2017/04/15.
 */
class DatasourceInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val environment = applicationContext.environment
        val resolver = RelaxedPropertyResolver(environment)

        val datasourceMap = HashMap<Any, Any>()
        owl.datasource.DbType.values().forEach {
            val subProperties = resolver.getSubProperties(groupKey("jdbc.datasource.owl", it))
            val url  = subProperties.get("url") as String?
            val username = subProperties.get("username") as String?
            val password = subProperties.get("password") as String?
            val driverName = subProperties.get("driverClassName") as String?
            val datasource = DataSourceBuilder.create()
                    .driverClassName(driverName)
                    .username(username)
                    .url(url)
                    .password(password)
                    .build()
            datasourceMap.set(it.label(), datasource)
        }
        registerBean(applicationContext, datasourceMap)
        println("aiueo")
    }

    private fun groupKey(prefix: String, dbType: owl.datasource.DbType): String {
        return MessageFormat.format("{0}.{1}.", prefix, dbType.label())
    }

    private fun registerBean(applicationContext: ConfigurableApplicationContext,
                             dataSources: Map<Any, Any>
    ) {
        val beanFactory: DefaultListableBeanFactory = applicationContext.beanFactory as DefaultListableBeanFactory
        val dataSource = RoutingDataSource(dataSources)
        dataSource.afterPropertiesSet()
        val name = MessageFormat.format("{0}", "owl.datasource")
//        beanFactory.registerSingleton(name, dataSource)
        beanFactory.registerDisposableBean(name, dataSource as DisposableBean)

        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        beanFactory.registerSingleton(
                MessageFormat.format("{0}.sessionFactory", "owl"),
                sqlSessionFactoryBean.getObject()
        )

        val dataSourceTransactionManager = DataSourceTransactionManager(dataSource)
        beanFactory.registerSingleton("owl.transaction", dataSourceTransactionManager)
    }

}
