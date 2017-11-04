package marshi.owl.web.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.Header
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpHead
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.message.BasicHeader
import org.apache.http.util.EntityUtils
import org.springframework.http.HttpHeaders
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
      val uri = URIBuilder()
          .setScheme(scheme)
          .setHost(host)
          .setPort(port)
          .setPath(path)
          .build()
      return Resource(uri)
   }

   inner class Resource(
       private val uri: URI
   ) {
      fun get(): Response {
         return response(httpClient.execute(HttpGet(uri)))
      }

      fun <T> post(body: T): Response {
         val httpPost = HttpPost(uri)
         val entity = mapper.writeValueAsString(body)
         httpPost.entity = StringEntity(entity, ContentType.APPLICATION_JSON)
         httpPost.setHeaders(defaultHeaders())
         return response(httpClient.execute(httpPost))
      }

      private fun response(httpResponse: HttpResponse): Response {
         return Response(
             httpResponse.statusLine.statusCode,
             httpResponse.entity
         )
      }

      private fun defaultHeaders(): Array<Header> {
         return arrayOf(
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