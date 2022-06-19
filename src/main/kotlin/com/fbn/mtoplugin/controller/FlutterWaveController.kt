package com.fbn.mtoplugin.controller

import com.fbn.mtoplugin.integrations.flutterwave.FlutterWaveService
import com.fbn.mtoplugin.request.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/flutterwave")
class FlutterWaveController(private val flutterWaveService: FlutterWaveService) {

    @PostMapping("/completeTransaction")
    fun completeTransactionPickUp(@Valid @RequestBody request: FlutterWaveCompletePickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.TransactionComplete(request)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/gettransaction")
    fun getTransactionsDetail(@Valid @RequestBody request: FlutterWavePickupRequest, errors : Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.getTransaction(request.transactionReference)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/query/transaction")
    fun queryTransactionPickUp(@PathVariable request: String) : ResponseEntity<*>{
        val response = flutterWaveService.paymentQuery(request)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/transaction/otp")
    fun postTransactionsOTP(@Valid @RequestBody request: FlutterWavePickupRequest, errors : Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.generateOTP(request.transactionReference)
        return ResponseEntity(response, HttpStatus.OK)
    }
}