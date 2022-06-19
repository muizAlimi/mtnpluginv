package com.fbn.mtoplugin.response.funtech

import com.google.gson.annotations.SerializedName

data class FuntechPaymentResponse(
    @SerializedName("ResponseCode") val responseCode : String?,
    @SerializedName("ResponseMessage") val responseMessage : String?,
    @SerializedName("TransactionReference") var transactionReference : String?
)
