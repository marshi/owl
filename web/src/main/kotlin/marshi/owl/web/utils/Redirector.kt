package marshi.owl.web.utils

import org.springframework.web.util.DefaultUriBuilderFactory
import org.springframework.web.util.UriBuilder

class Redirector(
    private val path: String,
    private val parameter: MutableMap<String, Any> = HashMap()
) {

    fun parameter(k: String, v: Any): Redirector {
        parameter.put(k, v)
        return this
    }

    fun redirect(): String = build("redirect")

    private fun build(type: String): String {
        if (parameter.isEmpty()) {
            return ""
        }
        val sb = StringBuilder("$type:$path?")
        parameter.entries.forEach {
            sb.append("${it.key}=${it.value}")
        }
        return sb.toString()
    }

}