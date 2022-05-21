package com.fbn.mtoplugin.controller
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
@RequestMapping("/api/v1/sendwave")
class SendWaveController(private val sendWaveTransactionService:SendWaveTransactionServices) {

    @PostMapping("/gettransactionstatus")
    fun getTransactionsStatus(@Valid @RequestBody pickupRequest: PickupRequest, errors : Errors) : ResponseEntity<*> {
       val list = sendWaveTransactionService.getTransactionStatus(pickupRequest.TransactionReference.toString())
        return ResponseEntity(list, HttpStatus.OK)
    }

    @PostMapping("/locktransaction")
    fun lockTransaction(@Valid @RequestBody pickupRequest: LockPickupRequest, errors : Errors) : ResponseEntity<SendWaveResponsePickUp> {
        val list = sendWaveTransactionService.lockTransaction(pickupRequest.TransactionReference.toString(),
                                                      pickupRequest.BranchCode.toString(),
                                                      pickupRequest.EmployeeID.toString())
        return ResponseEntity(list, HttpStatus.OK)
    }

    @PostMapping("/completeTransaction")
    fun completeTransaction(@Valid @RequestBody pickupRequest: CompletePickupRequest, errors : Errors) : ResponseEntity<*> {
        val list = sendWaveTransactionService.markTransactionComplete(pickupRequest.TransactionReference.toString(),
                                                              pickupRequest.TrackID.toString(),
                                                              pickupRequest.BranchCode.toString(),
                                                              pickupRequest.EmployeeID.toString(),
                                                              pickupRequest.OTP.toString()
        )
        return ResponseEntity(list, HttpStatus.OK)
    }

}