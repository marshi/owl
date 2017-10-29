package marshi.owl.web.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.HttpEntity
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.util.EntityUtils
import java.net.URI

class HttpApiTemplate(
        private val httpClient: HttpClient,
        private val mapper: ObjectMapper
) {

   fun resource(
           scheme: String,
           host: String,
           port: Int,
           path: String
   ): Resource{
      return Resource(scheme, host, port, path)
   }

   inner class Resource(
           private val scheme: String,
           private val host: String,
           private val port: Int,
           private val path: String
   ) {
      fun get(): Response {
         val uri = URIBuilder()
                 .setScheme(scheme)
                 .setHost(host)
                 .setPort(port)
                 .setPath(path)
                 .build()
         val getMethodResponse = httpClient.execute(HttpGet(uri))
         return Response(
                 getMethodResponse.statusLine.statusCode,
                 getMethodResponse.entity
         )
      }

   }

   inner class Response(
           val statusCode: Int,
           val httpEntity: HttpEntity
   ) {
      fun <T> getEntity(klass: Class<T>): T {
         return mapper.readValue(EntityUtils.toString(httpEntity), klass)
      }
   }

}