package com.fbn.mtoplugin.controller
import com.fbn.mtoplugin.integrations.firstapple.FirstAppleService
import com.fbn.mtoplugin.request.CompletePickupRequest
import com.fbn.mtoplugin.request.LockPickupRequest
import com.fbn.mtoplugin.request.PickupRequest
import com.fbn.mtoplugin.response.SendWaveResponsePickUp
import com.fbn.mtoplugin.integrations.sendwave.SendWaveTransactionServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/firstapple")
class FirstAppleController(private val firstAppleService: FirstAppleService) {

    @PostMapping("/gettransaction")
    fun getTransactionsStatus(@Valid @RequestBody pickupRequest: PickupRequest, errors : Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val response = firstAppleService.getTransaction(pickupRequest.TransactionReference!!)
        return ResponseEntity(response, HttpStatus.OK)
    }



}