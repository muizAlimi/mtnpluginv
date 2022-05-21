package com.fbn.mtoplugin.integrations.flutterwave

import com.fbn.mtoplugin.exceptions.FlutterWaveTransactionNotFound
import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.HoldPickupRequest
import com.fbn.mtoplugin.request.SimbaPayCompletePickupRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.flutterwave.AuthenticationResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWavePaymentResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWaveResponsePickUp
import com.fbn.mtoplugin.response.simbapay.SimbaResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.fbn.mtoplugin.util.EncodeUtil
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class FlutterWaveService(private val apiCaller: ApiCaller,
                         private val configUtil: ConfigUtil,
                         private val encodeUtil: EncodeUtil
) {

    fun getTransaction(transRef: String?): PickupResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer ${this.getAuthenticate().token}"
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.getFlutterwaveCall("${fAppleConfig["baseurl"]}/validate", tokenHeader, request)
        var testModel = Gson().fromJson(resp, FlutterWaveResponsePickUp::class.java)
        if (testModel.responseCode != "00") throw FlutterWaveTransactionNotFound("unable to find transaction")
        val result = testModel.apply { status = "READY"; transactionRef = transRef }
        return result.toTransaction("flutterwave");
    }

    fun markTransactionComplete(simbaPayRequest : SimbaPayCompletePickupRequest): BaseResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val transRef = simbaPayRequest.transactionReference
        val otp = simbaPayRequest.tellerID
        val bankSerial: String = "FBN" + encodeUtil.simbaPayNonce().toString()
        val key = "Bearer ${this.getAuthenticate().token}"
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        reqPayload.putOpt("BankRef", bankSerial)
        reqPayload.putOpt("OTP", otp)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postFlutterwaveCall("${fAppleConfig["baseurl"]}/notify", tokenHeader, request)
        var testModel = Gson().fromJson(resp, FlutterWavePaymentResponse::class.java)
        return testModel.toPayResponse();
    }

    fun lockTransaction(simbaRequest : HoldPickupRequest): SimbaResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val nonceKey: Long = encodeUtil.simbaPayNonce()
        val signatureKey: String = encodeUtil.simbaPaySignature("${fAppleConfig["secret"]}", "${fAppleConfig["companyid"]}", nonceKey)
        val nonceHeader = hashMapOf("firsthead" to "nonce", "firstheadkey" to nonceKey.toString())
        val tokenHeader = hashMapOf("secondhead" to "signature", "secondheadkey" to signatureKey)
        val companyHeader = hashMapOf("thirdhead" to "companyID", "thirdheadkey" to "${fAppleConfig["companyid"]}")
        val transRef = simbaRequest.transactionReference
        val reqPayload = JSONObject()
        reqPayload.putOpt("action",simbaRequest.action)
        reqPayload.putOpt("tellerID",simbaRequest.tellerID)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.putSimPayCall("${fAppleConfig["baseurl"]}/cash/$transRef", nonceHeader, tokenHeader, companyHeader, request)
        var testModel = Gson().fromJson(resp, SimbaResponse::class.java)
        return testModel;
        //return GetTransactionStatus(testModel).toPayResponse();
        //return Gson().fromJson(resp, SimbaTransactionResponse::class.java).toTransaction("simbapay")
    }
    fun generateOTP(transRef: String?): FlutterWaveResponsePickUp {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer ${this.getAuthenticate().token}"
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val reqPayload = JSONObject()
        reqPayload.putOpt("PaymentRef", transRef)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postFlutterwaveCall("${fAppleConfig["baseurl"]}/otp", tokenHeader, request)
        return Gson().fromJson(resp, FlutterWaveResponsePickUp::class.java);
    }

    fun paymentQuery(bankRef: String?): FlutterWavePaymentResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val key = "Bearer ${this.getAuthenticate().token}"
        val tokenHeader = hashMapOf("firsthead" to "Authorization", "firstheadkey" to key)
        val resp = this.apiCaller.getFlutterwaveQueryCall("${fAppleConfig["baseurl"]}/query?BankRef=$bankRef", tokenHeader)
        return Gson().fromJson(resp, FlutterWavePaymentResponse::class.java);
    }

    fun getAuthenticate(): AuthenticationResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("flutterwave")
        val reqPayload = JSONObject()
        reqPayload.putOpt("client_id", "${fAppleConfig["clientid"]}")
        reqPayload.putOpt("client_secret", "${fAppleConfig["clientsecret"]}")
        val request: String = reqPayload.toString()
        val response = apiCaller.getAuthCall("${fAppleConfig["baseurl"]}/api/v1/auth", request)
        return Gson().fromJson(response, AuthenticationResponse::class.java)
    }
}