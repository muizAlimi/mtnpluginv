package com.fbn.mtoplugin.integrations.flutterwave

import com.fbn.mtoplugin.exceptions.FlutterWaveTransactionNotFound
import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.FlutterWaveCompletePickupRequest
import com.fbn.mtoplugin.request.HoldPickupRequest
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.flutterwave.AuthenticationResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWavePaymentResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWaveResponsePickUp
import com.fbn.mtoplugin.response.simbapay.SimbaResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ApiCallerImpl
import com.fbn.mtoplugin.util.ConfigUtil
import com.fbn.mtoplugin.util.EncodeUtil
import com.google.gson.Gson
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FlutterWaveService(private val apiCaller: ApiCaller,
                         private val configUtil: ConfigUtil,
                         private val encodeUtil: EncodeUtil
) {
    val logger = LoggerFactory.getLogger(FlutterWaveService::class.java)

    fun getTransaction(transRef: String?): PickupResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer " + "${this.getAuthenticate().token}"
        println(key)
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.getFlutterwaveCall("${fAppleConfig["baseurl"]}/api/v1/payment/validate", tokenHeader, request)
        var testModel = Gson().fromJson(resp, FlutterWaveResponsePickUp::class.java)
        if (testModel.responseCode != "10000") throw FlutterWaveTransactionNotFound("unable to find transaction")
        val result = testModel.apply { status = "READY"; transactionRef = transRef }
        return result.toTransaction("FLWV");
    }

    fun markTransactionComplete(flutterPayRequest : PayTransRequest): BaseResponse {
        logger.info("Transaction Complete: $flutterPayRequest")
        println(flutterPayRequest.toString())
        println(flutterPayRequest?.transactionExtraData)
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val transRef = flutterPayRequest.transactionReference
        val bankSerial: String = "FBN" + encodeUtil.simbaPayNonce().toString()
        val key = "Bearer " + "${this.getAuthenticate().token}"
        println(key)
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        reqPayload.putOpt("BankRef", bankSerial)
        reqPayload.putOpt("OTP", flutterPayRequest.transactionExtraData)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postFlutterwaveCall("${fAppleConfig["baseurl"]}/api/v1/payment/notify", tokenHeader, request)
        var testModel = Gson().fromJson(resp, FlutterWavePaymentResponse::class.java)
        return testModel.toPayResponse();
    }

    fun TransactionComplete(flutterPayRequest: FlutterWaveCompletePickupRequest): FlutterWavePaymentResponse {
        logger.info("Transaction Complete: $flutterPayRequest")
        println(flutterPayRequest?.PaymentRef)
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val transRef = flutterPayRequest.PaymentRef
        val bankSerial: String = flutterPayRequest.BankRef
        val key = "Bearer " + "${this.getAuthenticate().token}"
        println(key)
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        reqPayload.putOpt("BankRef", bankSerial)
        reqPayload.putOpt("OTP", flutterPayRequest.OTP)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postFlutterwaveCall("${fAppleConfig["baseurl"]}/api/v1/payment/notify", tokenHeader, request)
        return Gson().fromJson(resp, FlutterWavePaymentResponse::class.java);
    }

    fun generateOTP(transRef: String): FlutterWaveResponsePickUp {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer " + "${this.getAuthenticate().token}"
        println(key)
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postFlutterwaveCall("${fAppleConfig["baseurl"]}/api/v1/payment/otp", tokenHeader, request)
        return Gson().fromJson(resp, FlutterWaveResponsePickUp::class.java);
    }

    fun paymentQuery(bankRef: String?): FlutterWavePaymentResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer " + "${this.getAuthenticate().token}"
        println(key)
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val resp = this.apiCaller.getFlutterwaveQueryCall("${fAppleConfig["baseurl"]}/api/v1/payment/query?BankRef=$bankRef", tokenHeader)
        return Gson().fromJson(resp, FlutterWavePaymentResponse::class.java);
    }

    fun getAuthenticate(): AuthenticationResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val reqPayload = JSONObject()
        reqPayload.putOpt("client_id", "${fAppleConfig["clientid"]}")
        reqPayload.putOpt("client_secret", "${fAppleConfig["clientsecret"]}")
        val request: String = reqPayload.toString()
        val response = apiCaller.getAuthCall("${fAppleConfig["baseurl"]}/api/v1/auth", request)
        //val response = "{\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTQwOTA1MDMsInN1YiI6IkZsdXR0ZXJ3YXZlIiwiaXNzIjoiaHR0cHM6Ly9mbHV0dGVyd2F2ZXByb2QuY29tLyIsImp0aSI6IjA1NWVhM2JkLTg0YWQtNDlhYS04M2M4LWE0YzQ5YmVjYTcxNyIsImV4cCI6MTY1NDA5NDEwM30.XWc0JHE_lzc8hyJeCfj_-pu64KLOA0FnD8tpQtc6x5k\",\"expires\":3600000}"
        return Gson().fromJson(response, AuthenticationResponse::class.java)
    }
}