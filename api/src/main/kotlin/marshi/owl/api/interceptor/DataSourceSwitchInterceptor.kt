package marshi.owl.api.interceptor

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import marshi.owl.data.rdb.DbType
import marshi.owl.data.rdb.SchemeContextHolder
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by a13178 on 2017/04/17.
 */
class DataSourceSwitchInterceptor : HandlerInterceptorAdapter() {

    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        val method = request?.method
        if (mutableSetOf("POST", "DELETE", "PUT", "PATCH").contains(method)) {
            SchemeContextHolder.set(DbType.Master)
        } else {
            SchemeContextHolder.set(DbType.Slave)
        }
        return true
    }

}