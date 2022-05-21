package com.fbn.mtoplugin.integrations.smallworld

import com.fbn.mtoplugin.extensions.*
import com.fbn.mtoplugin.gatewayresponse.smallword.MtnByFolioGatewayResponse
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.google.common.hash.Hashing
import com.google.gson.Gson
import org.json.XML
import org.springframework.stereotype.Service
import java.nio.charset.Charset

@Service
class SmallWorldServices(private val apiCaller: ApiCaller,
                        private val configUtil: ConfigUtil) {
    private val token = hashMapOf("firsthead" to "adeyemi", "firstheadkey" to "adeyemi")

    fun  callSmallWorld(request : String) : String {
        val config = configUtil.getCredentialsByMto("smallworld")
        val resp = apiCaller.postStringCall("${config["baseurl"]}", request, token)
        return resp!!
    }

    fun getMtnByFolioNumber(folioNumber: String): String? {
        val config = configUtil.getCredentialsByMto("smallworld")
        val password = Hashing.sha1().hashString(config["password"]!!, Charset.defaultCharset())
        val request = folioNumber.toMTNByFolio(config["username"]!!, "$password")
        val mtnByFolioResponse = apiCaller.postStringCall("${config["baseurl"]}", request, token)
        if (mtnByFolioResponse!!.contains("faultstring")) throw IllegalStateException(mtnByFolioResponse.toXMLError("smallworld"))
        val mtnObj = XML.toJSONObject(mtnByFolioResponse).extractRequest("getMtnByFolioResponse")
        return mtnObj.getString("return")
    }


    fun payoutAnywhere(payTransRequest: PayTransRequest): BaseResponse? {
        val folioNumber = payTransRequest.transactionReference ?: throw IllegalStateException("transactionReference is required")
        val locationCode = payTransRequest.transactionSoleId ?: throw IllegalStateException("transactionSoleId is required")
        val note = payTransRequest.transactionPayoutRemark ?: "paid"
        val payerCode = "101575"
        val config = configUtil.getCredentialsByMto("smallworld")
        val password = Hashing.sha1().hashString(config["password"]!!, Charset.defaultCharset());
        val request = this.getMtnByFolioNumber(folioNumber)!!.toPayoutAnywhere(locationCode, note, payerCode, config["username"]!!, "$password");
        val mtnByFolioResponse = apiCaller.postStringCall("${config["baseurl"]}", request, token)
        if (mtnByFolioResponse!!.contains("faultstring")) throw IllegalStateException(mtnByFolioResponse.toXMLError("smallworld"))
        val mtnObj = XML.toJSONObject(mtnByFolioResponse).extractRequest("payoutPickupAnywhereTransactionResponse")
        val responseObject = mtnObj.getJSONObject("return")
        return if (responseObject != null) BaseResponse("00", "Success") else BaseResponse("95", "An Error Occurred")
    }


    fun getExportMTNByFolio(folioNumber: String): PickupResponse {
        val mtn = getMtnByFolioNumber(folioNumber)!!
        val config = configUtil.getCredentialsByMto("smallworld")
        val password = Hashing.sha1().hashString(config["password"]!!, Charset.defaultCharset());
         val response = apiCaller.postStringCall("${config["baseurl"]}", mtn.toXMLRequest(config["username"]!!, "$password"), token)
        if (response!!.contains("faultstring")) throw IllegalStateException(response.toXMLError("smallworld"))
        val mtnObj = XML.toJSONObject(response).extractRequest("getTransactionExportByMtnResponse")
        val responseObject = mtnObj.getJSONObject("return")
        responseObject.put("responseCode", "00")
        responseObject.put("responseMessage", "Success")
        return Gson().fromJson(responseObject.toString(), MtnByFolioGatewayResponse::class.java).toTransaction("MT0293")
    }



}