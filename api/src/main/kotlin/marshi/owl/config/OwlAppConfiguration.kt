package marshi.owl.config

import marshi.owl.interceptor.DataSourceSwitchInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

/**
 * Created by a13178 on 2017/04/15.
 */
@Configuration
@MapperScan("owl.datasource.mapper")
class OwlAppConfiguration {

}
