package marshi.owl.config

import marshi.owl.interceptor.DataSourceSwitchInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created by a13178 on 2017/04/17.
 */
@Configuration
class ApiWebMvcConfiguration : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(DataSourceSwitchInterceptor())
    }

}