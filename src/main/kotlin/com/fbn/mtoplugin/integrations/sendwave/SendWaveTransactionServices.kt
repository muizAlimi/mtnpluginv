package com.fbn.mtoplugin.integrations.sendwave

import com.fbn.mtoplugin.exceptions.SendWaveTransactionNotFound
import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.SendWaveResponsePickUp
import com.fbn.mtoplugin.util.ApiCaller
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.stereotype.Service


@Service
class SendWaveTransactionServices(private val apiCaller: ApiCaller) {
    val uri = "https://app.sendwave.com/transfers"
    private val apiKey =  "Basic bmdfZmlyc3Rfc2FuZGJveDpCNzZOUWZTUWJTTlkzUFhEY0dCYjV1b2tzeTRkdXU2cUlRZGw="
    val header = hashMapOf("firsthead" to "Authorization", "firstheadkey" to apiKey)

    fun getTransactionStatus(TransactionReference: String): PickupResponse {
        val response = apiCaller.getStringCall("$uri/$TransactionReference", header)
        println(response)
        val resp = Gson().fromJson(response, SendWaveResponsePickUp::class.java)
        if (resp.confirmationCode.isNullOrEmpty()) throw SendWaveTransactionNotFound("unable to find transaction")
        val result = resp.apply { responseCode = "00"; responseMessage = "success" }
        return result.toTransaction("MT0292")
    }


    fun lockTransaction(TransactionReference: String, BranchCode: String, EmployeeID: String) : SendWaveResponsePickUp? {
        val reqPayload = JSONObject()
        reqPayload.putOpt("branch_code",BranchCode)
        reqPayload.putOpt("employee_id",EmployeeID)
        val response = apiCaller.postStringCall("$uri/$TransactionReference/lock", reqPayload.toString(),  header)
        val resp = Gson().fromJson(response, SendWaveResponsePickUp::class.java)
        println("Response: >>>>$resp")
        resp.apply { responseCode = "00"; responseMessage = "success" }
        return  resp
    }

    fun markTransactionComplete(TransactionReference: String, TrackID: String,
        BranchCode: String, EmployeeID: String, OTP: String): BaseResponse? {
        val reqPayload = JSONObject()
        reqPayload.putOpt("track_id", TrackID)
        reqPayload.putOpt("branch_code", BranchCode)
        reqPayload.putOpt("employee_id", EmployeeID)
        reqPayload.putOpt("otp", OTP)
        val rep = apiCaller.postStringCall(
            "https://app.sendwave.com/transfers/$TransactionReference",
            reqPayload.toString(),
            "Basic bmdfZmlyc3Rfc2FuZGJveDpCNzZOUWZTUWJTTlkzUFhEY0dCYjV1b2tzeTRkdXU2cUlRZGw="
        )
        return Gson().fromJson(rep, SendWaveResponsePickUp::class.java).toPayResponse()
    }

}
