package com.fbn.mtoplugin.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fbn.mtoplugin.response.BaseResponse
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.*
import org.springframework.web.util.UriComponentsBuilder
import java.io.IOException
import kotlin.collections.HashMap

@Component
class ApiCallerImpl : ApiCaller {

    @Autowired
    lateinit var restTemplate: RestTemplate

    val logger = LoggerFactory.getLogger(ApiCallerImpl::class.java)


    override fun postStringCall(uri: String, request: HashMap<String, Any>, token: String): HashMap<String, Any?> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri, entity, String::class.java)
            stringToHashMap(resp)
        } catch (err: HttpClientErrorException) {
            val error = HashMap<String, Any?>()
            error["error"] = err.message
            error
        }
    }

    override fun postStringCall(uri: String, request: String, token: String): String {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers["Authorization"] = token
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri, entity, String::class.java)!!
            resp
        } catch (err: HttpClientErrorException) {
            err.toString()
        }
    }

    fun stringToHashMap(Response: String?): HashMap<String, Any?> {
        return try {
            //System.out.println(Arrays.asList(result)); // method 1
            ObjectMapper()
                    .readValue(Response, object : TypeReference<HashMap<String, Any?>?>() {})!!
        } catch (e: IOException) {
            val error = HashMap<String, Any?>()
            error["error"] = e.message
            error
        }
    }


    override fun postStringCall(uri: String?, request: HashMap<String?, Any?>?, token: HashMap<String?, Any?>?): HashMap<String, Any?> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers[token!!["header"].toString()] = token["token"].toString()
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = this.restTemplate.postForObject(uri!!, entity, String::class.java)!!
            stringToHashMap(resp)
        } catch (err: HttpClientErrorException) {
            val error = HashMap<String, Any?>()
            error["error"] = err.message
            error
        }
    }

    override fun getStringCall(uri: String, token: HashMap<String, String>,username : String?, password : String?): String? {
        val headers = HttpHeaders().apply {
            contentType  = MediaType.APPLICATION_JSON
            accept = listOf(MediaType.APPLICATION_JSON)
        }
        if (username != null) headers.setBasicAuth(username, password!!)
        headers.add(token["firsthead"]!!, token["firstheadkey"])
        val entity = HttpEntity<Any>(headers)
        println("uri: $uri")
        return try {
            val resp  = this.restTemplate.exchange(uri,HttpMethod.GET, entity, String::class.java)
            println("response: $resp")
            println(resp.body)
            resp.body
        } catch (err: HttpClientErrorException) {
            println("response: ${err.responseBodyAsString}")
            err.responseBodyAsString
        } catch (err: HttpServerErrorException) {
            println("response: ${err.responseBodyAsString}")
            err.responseBodyAsString
        }
    }

    override fun postStringCall(uri: String?, request: String?, token: HashMap<String, String>): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers[token["firsthead"]!!] = token["firstheadkey"]
        val entity = HttpEntity<Any>(request, headers)
        println("uri: $uri")
        println("request: $request")
        return try {
            val resp  = this.restTemplate.postForObject(uri!!, entity, String::class.java)
            println("response: $resp")
            println(resp)
            resp
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            Gson().toJson(BaseResponse("55", err.responseBodyAsString))
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            println(err.responseBodyAsString)
            val resp = Gson().toJson(BaseResponse("50", err.responseBodyAsString))
            println("response: $resp")
            return resp
        }
    }

    override fun postStringCall(uri: String?, request: String?): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity(request, headers)
        return try {
            restTemplate.postForObject(uri!!, entity, String::class.java)!!
        } catch (err: HttpClientErrorException) {
            err.localizedMessage
        }
    }


    override fun getStringCall(uri: String, username: String, password: String?, params: Map<String, String>): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers.setBasicAuth(username, password!!)
        val entity = HttpEntity<Void>(headers)
        logger.info("headers: $headers")
        return try {
            val uriBuilder = UriComponentsBuilder.fromUriString(uri).build().expand(params)
            logger.info("uri: ${uriBuilder.toUriString()}")
            val resp = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,  entity, String::class.java)
            logger.info("response: $resp")
            resp.body
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            err.responseBodyAsString
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            err.responseBodyAsString
        }
    }

    override fun getSimPayCall(
        uri: String,
        nonce: HashMap<String, String>,
        token: HashMap<String, String>,
        company: HashMap<String, String>
    ): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers[nonce["firsthead"]!!] = nonce["firstheadkey"]
        headers[token["secondhead"]!!] = token["secondheadkey"]
        headers[company["thirdhead"]!!] = company["thirdheadkey"]
        val entity = HttpEntity<Any>(headers)
        println("uri: $uri")
        headers.forEach {
            println("${it.key}: ${it.value}")
        }
        logger.info("headers: $headers")
        return try {
            val resp  = this.restTemplate.exchange(uri,HttpMethod.GET, entity, String::class.java)
            println("response: $resp")
            println(resp.body)
            resp.body
        } catch (err: HttpClientErrorException) {
            println("response: ${err.responseBodyAsString}")
            err.responseBodyAsString
        } catch (err: HttpServerErrorException) {
            println("response: ${err.responseBodyAsString}")
            err.responseBodyAsString
        }
    }

    override fun postSimPayCall(
        uri: String,
        nonce: HashMap<String, String>,
        token: HashMap<String, String>,
        company: HashMap<String, String>,
        request: String
    ): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers[nonce["firsthead"]!!] = nonce["firstheadkey"]
        headers[token["secondhead"]!!] = token["secondheadkey"]
        headers[company["thirdhead"]!!] = company["thirdheadkey"]
        val entity = HttpEntity<Any>(request, headers)
        println("uri: $uri")
        println("request: $request")
        headers.forEach {
            println("${it.key}: ${it.value}")
        }
        logger.info("headers: $headers")
        return try {
            val resp  = this.restTemplate.postForObject(uri!!, entity, String::class.java)
            println("response: $resp")
            println(resp)
            resp
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            Gson().toJson(BaseResponse("55", err.responseBodyAsString))
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            println(err.responseBodyAsString)
            val resp = Gson().toJson(BaseResponse("50", err.responseBodyAsString))
            println("response: $resp")
            return resp
        }

    }

    override fun putSimPayCall(
        uri: String,
        nonce: HashMap<String, String>,
        token: HashMap<String, String>,
        company: HashMap<String, String>,
        request: String
    ): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers[nonce["firsthead"]!!] = nonce["firstheadkey"]
        headers[token["secondhead"]!!] = token["secondheadkey"]
        headers[company["thirdhead"]!!] = company["thirdheadkey"]
        val entity = HttpEntity<Any>(request, headers)
        println("uri: $uri")
        println("request: $request")
        headers.forEach {
            println("${it.key}: ${it.value}")
        }
        logger.info("headers: $headers")
        return try {
            val resp = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, String::class.java)
            println("response: $resp")
            println(resp.body)
            resp.body
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            Gson().toJson(BaseResponse("55", err.responseBodyAsString))
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            println(err.responseBodyAsString)
            val resp = Gson().toJson(BaseResponse("50", err.responseBodyAsString))
            println("response: $resp")
            return resp
        }
    }

    override fun getAuthCall(uri: String, request: String): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<Any>(request, headers)
        println("uri: $uri")
        println("request: $request")
        headers.forEach {
            println("${it.key}: ${it.value}")
        }
        logger.info("headers: $headers")
        return try {
            val resp = this.restTemplate.exchange(uri, HttpMethod.POST, entity, String::class.java)
            println("response: $resp")
            println(resp.body)
            resp.body
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            Gson().toJson(BaseResponse("55", err.responseBodyAsString))
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            println(err.responseBodyAsString)
            val resp = Gson().toJson(BaseResponse("50", err.responseBodyAsString))
            println("response: $resp")
            return resp
        }
    }

    override fun getFlutterwaveCall(uri: String, token: HashMap<String, String>, request: String): String? {
        TODO("Not yet implemented")
    }

    override fun postFlutterwaveCall(uri: String, token: HashMap<String, String>, request: String): String? {
        TODO("Not yet implemented")
    }

    override fun postStringCall(uri: String, body : String?, username: String, password: String?, params: Map<String, String>): String? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers.setBasicAuth(username, password!!)
        val entity = HttpEntity(body, headers)
        logger.info("headers: $headers")
        return try {
            val uriBuilder = UriComponentsBuilder.fromUriString(uri).build().expand(params)
            logger.info("uri: ${uriBuilder.toUriString()}")
            val resp = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST,  entity, String::class.java)
            logger.info("response: $resp")
            resp.body
        } catch (err: HttpClientErrorException) {
            println("clienterrorresponse: ${err.responseBodyAsString}")
            err.responseBodyAsString
        } catch (err: HttpServerErrorException){
            println("servererrorresponse: ${err.responseBodyAsString}")
            err.responseBodyAsString
        }
    }


}