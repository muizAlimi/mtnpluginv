package com.fbn.mtoplugin.integrations.idtps

import com.fbn.mtoplugin.extensions.*
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.idtps.LookupResponse
import com.fbn.mtoplugin.response.idtps.PaymentResponse
import com.fbn.mtoplugin.response.idtps.ReleaseResponse
import com.fbn.mtoplugin.response.idtps.ReservationResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.google.gson.Gson
import org.json.XML
import org.springframework.stereotype.Service

@Service
class IDTPSService(private val apiCaller: ApiCaller,
                   private val configUtil: ConfigUtil) {
      private val token = hashMapOf("firsthead" to "adeyemi", "firstheadkey" to "adeyemi")

    fun getCashPickUp(transactionNumber : String) : PickupResponse {
        val config =  configUtil.getCredentialsByMto("idtps")
        val request =  transactionNumber.toIDTPSXMLRequest(config)
        val response = apiCaller.postStringCall(config["baseurl"]!!, request, token)
        if (response!!.contains("faultstring")) throw IllegalStateException(response.toXMLError("idtps"))
        val mtnObj = XML.toJSONObject(response).extractIDTPSResponse("ConsultaGiroResponse").getString("result")
        return Gson().fromJson(mtnObj, LookupResponse::class.java).toTransaction("MT0297")
    }

    fun reserveTransaction(payTransRequest: PayTransRequest, config : HashMap<String,String>) : ReservationResponse {
        val request =  payTransRequest.toReserveRequest(config)
        val response = apiCaller.postStringCall(config["baseurl"]!!, request, token)
        if (response!!.contains("faultstring")) throw IllegalStateException(response.toXMLError("idtps"))
        val resultObject = XML.toJSONObject(response).extractIDTPSResponse("ReservaResponse").getString("result")
        return Gson().fromJson(resultObject, ReservationResponse::class.java)
    }

    fun releaseTransaction(payTransRequest: PayTransRequest, config : HashMap<String,String>, reservationId: String?) : BaseResponse {
        val request =  payTransRequest.toReleaseRequest(config, reservationId)
        val response = apiCaller.postStringCall(config["baseurl"]!!, request, token)
        if (response!!.contains("faultstring")) throw IllegalStateException(response.toXMLError("idtps"))
        val resultObject = XML.toJSONObject(response).extractIDTPSResponse("LiberaResponse").getString("result")
        return Gson().fromJson(resultObject, ReleaseResponse::class.java).toBaseResponse()
    }

    fun markTransactionAsPaid(payTransRequest: PayTransRequest) : BaseResponse {
        val config = configUtil.getCredentialsByMto("idtps")
        val reserveResponse =  this.reserveTransaction(payTransRequest, config)
        if (reserveResponse.CODIGO_MENSAJE != 1600) throw IllegalStateException("unable to reserve transaction")
        val request = payTransRequest.toPayment(config, reserveResponse.ID_RESERVA)
        val response = apiCaller.postStringCall(config["baseurl"]!!, request, token)
        if (response!!.contains("faultstring")) throw IllegalStateException(response.toXMLError("idtps"))
        val result = XML.toJSONObject(response).extractIDTPSResponse("AutorizaPagoResponse").getString("result")
        val resp  = Gson().fromJson(result, PaymentResponse::class.java)
        return when(resp.CODIGO_MENSAJE != 1800) {
           true ->  this.releaseTransaction(payTransRequest, config, reserveResponse.ID_RESERVA)
           else ->  resp.toBaseResponse()
        }

    }

}




