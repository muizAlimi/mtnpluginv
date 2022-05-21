package com.fbn.mtoplugin.integrations.simbapay

import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.HoldPickupRequest
import com.fbn.mtoplugin.request.SimbaPayCompletePickupRequest
import com.fbn.mtoplugin.request.SimbaPayPickupRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.simbapay.GetTransactionStatus
import com.fbn.mtoplugin.response.simbapay.SimbaResponse
import com.fbn.mtoplugin.response.simbapay.SimbaResultResponse
import com.fbn.mtoplugin.response.simbapay.SimbaTransactionResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.fbn.mtoplugin.util.EncodeUtil
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class SimbaPayServices(private val apiCaller: ApiCaller,
                       private val configUtil: ConfigUtil, private val encodeUtil: EncodeUtil
) {

    fun getTransaction(transRef: String?): PickupResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("simbapay")
        val nonceKey: Long = encodeUtil.simbaPayNonce()
        val signatureKey: String =
            encodeUtil.simbaPaySignature("${fAppleConfig["secret"]}", "${fAppleConfig["companyid"]}", nonceKey)
        val nonceHeader = hashMapOf("firsthead" to "nonce", "firstheadkey" to nonceKey.toString())
        val tokenHeader = hashMapOf("secondhead" to "signature", "secondheadkey" to signatureKey)
        val companyHeader = hashMapOf("thirdhead" to "companyID", "thirdheadkey" to "${fAppleConfig["companyid"]}")
        val resp = this.apiCaller.getSimPayCall("${fAppleConfig["baseurl"]}/cash/$transRef", nonceHeader, tokenHeader, companyHeader)
        //val resp = "{\"status\":\"OK\",\"error\":null,\"sender\":{\"name\":\"Martha Sender\",\"mobile\":\"447722012332\",\"address1\":\"15 Avenue\",\"city\":\"London\",\"state\":\"London\",\"postCode\":\"EC2A4BX\",\"country\":\"GB\",\"idNumber\":\"1122233322\",\"idExpiry\":\"2022-02-21\"},\"recipient\":{\"name\":\"James Recipient\",\"mobile\":\"256781002001\",\"address1\":\"1 Street\",\"city\":\"Lagos\",\"state\":\"Lagos\",\"postCode\":\"2000\",\"country\":\"NG\",\"idNumber\":null,\"idExpiry\":null},\"transaction\":{\"sendAmount\":0.0,\"receiveAmount\":5000.0,\"sendCurrency\":\"GBP\",\"receiveCurrency\":\"USD\",\"status\":\"READY\",\"transRef\":\"SPCT81100000002\"}}"
        var testModel = Gson().fromJson(resp, SimbaResultResponse::class.java)
        return SimbaTransactionResponse(testModel).toTransaction("simbapay");
    }

    fun markTransactionComplete(simbaPayRequest : SimbaPayCompletePickupRequest): BaseResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("simbapay")
        val nonceKey: Long = encodeUtil.simbaPayNonce()
        val signatureKey: String = encodeUtil.simbaPaySignature("${fAppleConfig["secret"]}", "${fAppleConfig["companyid"]}", nonceKey)
        val nonceHeader = hashMapOf("firsthead" to "nonce", "firstheadkey" to nonceKey.toString())
        val tokenHeader = hashMapOf("secondhead" to "signature", "secondheadkey" to signatureKey)
        val companyHeader = hashMapOf("thirdhead" to "companyID", "thirdheadkey" to "${fAppleConfig["companyid"]}")
        val transRef = simbaPayRequest.transactionReference
        val reqPayload = JSONObject()
        reqPayload.putOpt("notes",simbaPayRequest.notes)
        reqPayload.putOpt("tellerID",simbaPayRequest.tellerID)
        val request: String = reqPayload.toString()
        val resp = this.apiCaller.postSimPayCall("${fAppleConfig["baseurl"]}/cash/$transRef", nonceHeader, tokenHeader, companyHeader, request)
        var testModel = Gson().fromJson(resp, SimbaResponse::class.java)
        return GetTransactionStatus(testModel).toPayResponse();
        //return Gson().fromJson(resp, SimbaTransactionResponse::class.java).toTransaction("simbapay")
    }

    fun lockTransaction(simbaRequest : HoldPickupRequest): SimbaResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("simbapay")
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
}