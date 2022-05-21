package com.fbn.mtoplugin.controller

import com.fbn.mtoplugin.integrations.simbapay.SimbaPayServices
import com.fbn.mtoplugin.request.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/simbapay")
class SimbaPayController(private val simbaPayServices: SimbaPayServices) {

    //Transaction Picked Up: Once the cash has been received by the customer,
    // this method is called to notify the SimbaPay system of the action
    @PostMapping("/completeTransaction")
    fun completeTransactionPickUp(@Valid @RequestBody request: SimbaPayCompletePickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = simbaPayServices.markTransactionComplete(request)
        return ResponseEntity(response, HttpStatus.OK)
    }

    //Get Transaction Details: To get the details of a cash pickup transaction
    @PostMapping("/gettransaction")
    fun getTransactionsDetail(@Valid @RequestBody request: SimbaPayPickupRequest, errors : Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = simbaPayServices.getTransaction(request.transactionReference)
        return ResponseEntity(response, HttpStatus.OK)
    }

    //Transaction Set for Hold/Ready for Pickup: An optional step for you is to hold a transaction for a specific teller/branch, therefore stopping it being picked
    //up from another branch, but before setting it as picked up.
    @PutMapping("/locktransaction")
    fun lockTransactionPickUp(@Valid @RequestBody request: HoldPickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = simbaPayServices.lockTransaction(request)
        return ResponseEntity(response, HttpStatus.OK)
    }
}