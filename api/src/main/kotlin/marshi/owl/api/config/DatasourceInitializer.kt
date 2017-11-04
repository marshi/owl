package marshi.owl.api.config

import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import marshi.owl.data.rdb.DbType
import marshi.owl.data.rdb.RoutingDataSource
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.core.env.get
import java.text.MessageFormat

/**
 * Created by a13178 on 2017/04/15.
 */
class DatasourceInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val environment = applicationContext.environment

        val datasourceMap = HashMap<Any, Any>()
        val datasourceKey = "jdbc.datasource.owl"
        DbType.values().forEach {
            val url  = environment.get("$datasourceKey.${it.label()}.url") as String?
            val username = environment.get("$datasourceKey.${it.label()}.username") as String?
            val password = environment.get("$datasourceKey.${it.label()}.password") as String?
            val driverName = environment.get("$datasourceKey.${it.label()}.driverClassName") as String?
            val datasource = DataSourceBuilder.create()
                    .driverClassName(driverName)
                    .username(username)
                    .url(url)
                    .password(password)
                    .build()
            datasourceMap.set(it.label(), datasource)
        }
        registerBean(applicationContext, datasourceMap)
    }

    private fun groupKey(prefix: String, dbType: DbType): String {
        return MessageFormat.format("{0}.{1}.", prefix, dbType.label())
    }

    private fun registerBean(applicationContext: ConfigurableApplicationContext,
                             dataSources: Map<Any, Any>
    ) {
        val beanFactory: DefaultListableBeanFactory = applicationContext.beanFactory as DefaultListableBeanFactory
        val dataSource = RoutingDataSource(dataSources)
        dataSource.afterPropertiesSet()
        val name = MessageFormat.format("{0}", "marshi.owl.datasource")
//        beanFactory.registerSingleton(name, dataSource)
        beanFactory.registerDisposableBean(name, dataSource as DisposableBean)

        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        beanFactory.registerSingleton(
                MessageFormat.format("{0}.sessionFactory", "marshi.owl"),
                sqlSessionFactoryBean.getObject()
        )

        val dataSourceTransactionManager = DataSourceTransactionManager(dataSource)
        beanFactory.registerSingleton("transactionManager", dataSourceTransactionManager)
    }

}
