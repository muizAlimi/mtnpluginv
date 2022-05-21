package com.fbn.mtoplugin.controller

import com.fbn.mtoplugin.integrations.flutterwave.FlutterWaveService
import com.fbn.mtoplugin.request.GetTransExportByFolio
import com.fbn.mtoplugin.request.HoldPickupRequest
import com.fbn.mtoplugin.request.SimbaPayCompletePickupRequest
import com.fbn.mtoplugin.request.SimbaPayPickupRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/flutterwave")
class FlutterWaveController(private val flutterWaveService: FlutterWaveService) {

    @PostMapping("/completeTransaction")
    fun completeTransactionPickUp(@Valid @RequestBody request: SimbaPayCompletePickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.markTransactionComplete(request)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/gettransaction")
    fun getTransactionsDetail(@Valid @RequestBody request: SimbaPayPickupRequest, errors : Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.getTransaction(request.transactionReference)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/locktransaction")
    fun lockTransactionPickUp(@Valid @RequestBody request: HoldPickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = flutterWaveService.lockTransaction(request)
        return ResponseEntity(response, HttpStatus.OK)
    }
}