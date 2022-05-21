package com.fbn.mtoplugin.exceptions

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.ResponseErrorHandler
import java.io.IOException

@Component
class RestErrorHandler : ResponseErrorHandler {

    private val log = LoggerFactory.getLogger(RestErrorHandler::class.java)

    @Throws(IOException::class)
    override fun hasError(p0: ClientHttpResponse): Boolean {
        return DefaultResponseErrorHandler().hasError(p0)
    }

    @Throws(IOException::class)
    override fun handleError(response: ClientHttpResponse) {
        when{
            response.statusCode.series() === HttpStatus.Series.SERVER_ERROR -> {
                log.warn("{${response.rawStatusCode}: ${response.body}}")
                response.statusCode
            }
            response.statusCode.series() === HttpStatus.Series.CLIENT_ERROR -> {
                log.warn("{${response.rawStatusCode}: ${response.body}}")
                response.statusCode
            }
        }
    }
}