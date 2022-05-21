package com.fbn.mtoplugin.exceptions

import com.fbn.mtoplugin.response.BaseResponse
import org.apache.http.conn.HttpHostConnectException
import org.json.JSONException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.xml.sax.SAXParseException
import java.io.FileNotFoundException


@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(IllegalStateException::class)
    fun handleException(ex: IllegalStateException): ResponseEntity<*> {
        val response = BaseResponse("93", ex.message?:"something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(ApiErrorException::class)
    fun handleApiErrorException(ex: ApiErrorException): ResponseEntity<*> {
        ex.printStackTrace()
        return ResponseEntity(BaseResponse("93", ex.message?:"something went wrong"), HttpStatus.OK)
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ex: AccessDeniedException): ResponseEntity<*> {
        val response = BaseResponse("93", ex.message?:"something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(SAXParseException::class)
    fun handleXMLParseException(ex: SAXParseException): ResponseEntity<*> {
        val response = BaseResponse("90", "500 error from server")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(SendWaveTransactionNotFound::class)
    fun handleSendWaveTransactionNotFound(ex: SendWaveTransactionNotFound): ResponseEntity<*> {
        val response = BaseResponse("90", ex.message?:"something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }


    @ExceptionHandler(JSONException::class)
    fun handleJSONException(ex: JSONException): ResponseEntity<*> {
        val response = BaseResponse("65", ex.message?:"something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }



    @ExceptionHandler(HttpClientErrorException::class)
    fun handleClientException(ex: HttpClientErrorException): ResponseEntity<*> {
        val response = BaseResponse("93", "something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(HttpServerErrorException::class)
    fun handleServerException(ex: HttpServerErrorException): ResponseEntity<*> {
        val response = BaseResponse("93", "something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(NumberFormatException::class)
    fun handleNumberFormatException(ex: NumberFormatException): ResponseEntity<*> {
        val response = BaseResponse("93", "invalid amount format")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(HttpHostConnectException::class)
    fun handleHttpException(ex: HttpHostConnectException): ResponseEntity<*> {
        val response = BaseResponse("93", ex.message?:"something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }

    @ExceptionHandler(FileNotFoundException::class)
    fun handleFileNotFoundException(ex: FileNotFoundException): ResponseEntity<*> {
        val response = BaseResponse("93", ex.message?:"Something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }



    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<*> {
        val response = BaseResponse("93", "Something went wrong")
        ex.printStackTrace()
        return ResponseEntity.ok(response)
    }






}