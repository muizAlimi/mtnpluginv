package com.fbn.mtoplugin.response.simbapay

import com.google.gson.annotations.SerializedName

data class TransactionStatus(
    @SerializedName("status") val status : String
)
