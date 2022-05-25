package com.fbn.mtoplugin.controller

import com.fbn.mtoplugin.integrations.firstapple.FirstAppleService
import com.fbn.mtoplugin.integrations.flutterwave.FlutterWaveService
import com.fbn.mtoplugin.integrations.idtps.IDTPSService
import com.fbn.mtoplugin.request.*
import com.fbn.mtoplugin.integrations.sendwave.SendWaveTransactionServices
import com.fbn.mtoplugin.integrations.simbapay.SimbaPayServices
import com.fbn.mtoplugin.integrations.smallworld.SmallWorldServices
import com.fbn.mtoplugin.integrations.thunes.ThunesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(private val sendWaveTransactionServices: SendWaveTransactionServices,
                            private val smallWorldServices: SmallWorldServices,
                            private  val firstAppleService: FirstAppleService,
                            private val thunesService: ThunesService,
                            private  val idtpsService: IDTPSService,
                            private val simbaServices: SimbaPayServices,
                            private val flutterService: FlutterWaveService
) {


    @PostMapping("/cash/pickup")
    fun cashPickupEndpoint(@Valid @RequestBody pickupRequest: PickupRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val trans = when(pickupRequest.TransactionMtoCode?.lowercase()){
            "mt0292" -> sendWaveTransactionServices.getTransactionStatus(pickupRequest.TransactionReference!!)
            "mt0293" -> smallWorldServices.getExportMTNByFolio(pickupRequest.TransactionReference!!)
            "fapple" -> firstAppleService.getTransaction(pickupRequest.TransactionReference!!)
            "mt0297" -> idtpsService.getCashPickUp(pickupRequest.TransactionReference!!)
            "thu" -> thunesService.getTransactionDetails(pickupRequest.TransactionReference!!)
            "simb" -> simbaServices.getTransaction(pickupRequest.TransactionReference!!)
            "flwv" -> flutterService.getTransaction(pickupRequest.TransactionReference!!)
            else -> throw IllegalStateException("MTO NOT FOUND")
        }
        return ResponseEntity(trans, HttpStatus.OK)
    }

    @PostMapping("/confirm-payment")
    fun payTransaction(@Valid @RequestBody payTransRequest: PayTransRequest, errors : Errors) : ResponseEntity<*>{
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val trans = when(payTransRequest.transactionMtoCode?.lowercase()){
            "mt0293" -> smallWorldServices.payoutAnywhere(payTransRequest)
            "fapple" -> firstAppleService.payTransaction(payTransRequest)
            "mt0297" -> idtpsService.markTransactionAsPaid(payTransRequest)
            "thu" -> thunesService.completeCollection(payTransRequest)
            else -> throw IllegalStateException("MTO NOT FOUND")
        }
        return ResponseEntity(trans, HttpStatus.OK)
    }


}