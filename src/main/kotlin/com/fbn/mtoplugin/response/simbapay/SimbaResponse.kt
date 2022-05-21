package com.fbn.mtoplugin.response.simbapay

import com.google.gson.annotations.SerializedName

data class SimbaResponse(
    @SerializedName("status") val status : String,
    @SerializedName("error") val error : String,
    @SerializedName("transaction") val transaction : TransactionStatus
)
