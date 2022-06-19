package com.fbn.mtoplugin.integrations.funtech

import com.fbn.mtoplugin.exceptions.FuntechTransactionNotFound
import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.request.funtech.*
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.funtech.FuntechPaymentResponse
import com.fbn.mtoplugin.response.funtech.FuntechResponsePickUp
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.google.gson.Gson
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@Service
class FunTechService(private val apiCaller: ApiCaller,
                     private val configUtil: ConfigUtil) {

    val logger = LoggerFactory.getLogger(FunTechService::class.java)
    val mapper = jacksonObjectMapper()

    fun getTransaction(transRef: String?): PickupResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("funtech")
        val spTran = SpaTransactionFind(transRef,"FBN333023")
        val funtechRequest = ApiRequest("${fAppleConfig["accessaffiliatenumber"]}", "${fAppleConfig["accessservicenumber"]}",
        "${fAppleConfig["accessusername"]}","${fAppleConfig["accesspassword"]}","${fAppleConfig["accesshashdata"]}",
            spTran)
        val reqPayload = FunTechPickupRequest(funtechRequest)
        val userJson = mapper.writeValueAsString(reqPayload)
        println(userJson)
        val request: String = userJson.toString()
        println(request)
        val resp = this.apiCaller.postFuntechTransactionCall("${fAppleConfig["baseurl"]}/BusinessApi.svc/json/SPATransactionFind", request)
        var testModel = Gson().fromJson(resp, FuntechResponsePickUp::class.java)
        if (testModel.ResponseCode != "00") throw FuntechTransactionNotFound("unable to find transaction")
        val result = testModel.apply { transactionReference = transRef }
        return result.toTransaction("FUNTECH");
    }

    fun markTransactionComplete(funtechPayRequest : PayTransRequest): BaseResponse {
        logger.info("Transaction Complete: $funtechPayRequest")
        println(funtechPayRequest.toString())
        val fAppleConfig = configUtil.getCredentialsByMto("funtech")
        val spTran = TransactionConfirmPayout(funtechPayRequest.transactionReference,"FBN333023")
        val funtechRequest = com.fbn.mtoplugin.request.firstapple.ApiRequest("${fAppleConfig["accessaffiliatenumber"]}", "${fAppleConfig["accessservicenumber"]}",
            "${fAppleConfig["accessusername"]}","${fAppleConfig["accesspassword"]}","${fAppleConfig["accesshashdata"]}",
            spTran)
        val reqPayload = FunTechConfirmPayout(funtechRequest)
        val userJson = mapper.writeValueAsString(reqPayload)
        println(userJson)
        val request: String = userJson.toString()
        println(request)
        val resp = this.apiCaller.postFuntechTransactionCall("${fAppleConfig["baseurl"]}/BusinessApi.svc/json/SPATransactionConfirmPayout", request)
        var testModel = Gson().fromJson(resp, FuntechPaymentResponse::class.java)
        val result = testModel.apply { transactionReference = funtechPayRequest.transactionReference }
        return result.toPayResponse();
    }

    fun TransactionPayout(funtechPayRequest: PayTransRequest): BaseResponse {
        logger.info("Transaction payout: $funtechPayRequest")
        println(funtechPayRequest?.transactionReference)
        val fAppleConfig = configUtil.getCredentialsByMto("funtech")
        val generateRef: String = ""
        val spTran = TransactionRequestPayout(funtechPayRequest.transactionReference,"FBN333023",
            generateRef,funtechPayRequest.transactionReceiverBirthDate,"NGA",
            funtechPayRequest.transactionReceiverIDDocumentNumber,funtechPayRequest.transactionReceiverIDDocumentTypeCode,
            funtechPayRequest.transactionReceiverIDDocumentExpirationDate, funtechPayRequest.transactionReceiverIDDocumentDeliveryDate)
        val funtechRequest = com.fbn.mtoplugin.request.ApiRequest("${fAppleConfig["accessaffiliatenumber"]}", "${fAppleConfig["accessservicenumber"]}",
            "${fAppleConfig["accessusername"]}","${fAppleConfig["accesspassword"]}","${fAppleConfig["accesshashdata"]}",
            spTran)
        val reqPayload = FunTechRequestPayout(funtechRequest)
        val userJson = mapper.writeValueAsString(reqPayload)
        println(userJson)
        val request: String = userJson.toString()
        println(request)
        val resp = this.apiCaller.postFuntechTransactionCall("${fAppleConfig["baseurl"]}/BusinessApi.svc/json/SPATransactionRequestForPayout", request)
        var testModel = Gson().fromJson(resp, FuntechPaymentResponse::class.java)
        val result = testModel.apply { transactionReference = funtechPayRequest.transactionReference }
        return result.toPayResponse();
    }

}