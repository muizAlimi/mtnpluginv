package com.fbn.mtoplugin.integrations.thunes

import com.fbn.mtoplugin.exceptions.ApiErrorException
import com.fbn.mtoplugin.extensions.toCreateCollection
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.request.thunes.CreateCollectionRequest
import com.fbn.mtoplugin.request.thunes.ThunesTransaction
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.thunes.CreateCollectionResponse
import com.fbn.mtoplugin.util.ApiCaller
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ThunesService(private val apiCaller: ApiCaller) {

    @Value("\${thunes.dev.baseurl}")
    private val THUNES_BASE_URL : String? = null
    @Value("\${thunes.dev.username}")
    private val THUNES_USERNAME : String? = null
    @Value("\${thunes.dev.password}")
    private val THUNES_PASSWORD : String? = null


    fun getTransactionDetails(transactionId  : String) : PickupResponse{
        val url = "$THUNES_BASE_URL/v1/cash-pickup/transactions/code-{reference}"
        val params =  mapOf("reference" to transactionId)
        val response = apiCaller.getStringCall(url, THUNES_USERNAME!!, THUNES_PASSWORD,  params)
        val resp =  Gson().fromJson(response, ThunesTransaction::class.java)
        if (resp.errors?.isNotEmpty() == true) throw ApiErrorException(resp.errors?.map { it.message }?.joinToString(",") ?: "")
        return resp.toTransaction("THU")
    }



    fun createCollection(createCollection: CreateCollectionRequest) : CreateCollectionResponse{
        val url = "$THUNES_BASE_URL/v1/cash-pickup/transactions/code-{reference}/collections"
        val params =  mapOf("reference" to createCollection.transaction_reference!!)
        val body = Gson().toJson(createCollection)
        val response = apiCaller.postStringCall(url, body, THUNES_USERNAME!!, THUNES_PASSWORD,  params)
        val resp = Gson().fromJson(response, CreateCollectionResponse::class.java)
        if (resp.errors?.isNotEmpty() == true) throw ApiErrorException(resp.errors?.map { it.message }?.joinToString(",") ?: "")
        return resp
    }


    fun completeCollection(payTransRequest: PayTransRequest) : BaseResponse {
        val resp = this.createCollection(payTransRequest.toCreateCollection())
        if (resp.status != "10000") throw IllegalStateException(resp.status_message)
        resp.id ?:  throw ApiErrorException("unable to obtain collection id")
        val url = "$THUNES_BASE_URL/v1/cash-pickup/collections/{collection-identifier}/complete"
        val params =  mapOf("collection-identifier" to "${resp.id}")
        val response = apiCaller.postStringCall(url, "", THUNES_USERNAME!!, THUNES_PASSWORD,  params)
        val output =  Gson().fromJson(response, CreateCollectionResponse::class.java)
        if (resp.errors?.isNotEmpty() == true) throw ApiErrorException(resp.errors?.map { it.message }?.joinToString(",") ?: "")
        return when(output.status.equals("70000")){
            false -> {
                val failedurl = "$THUNES_BASE_URL/v1/cash-pickup/collections/{collection-identifier}/cancel"
                apiCaller.postStringCall(failedurl, "", THUNES_USERNAME, THUNES_PASSWORD,  params)
                BaseResponse("82", output.status_message)
            }
            else -> BaseResponse("00", "success")
        }
    }


}


