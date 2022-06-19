package com.fbn.mtoplugin.request.funtech

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class TransactionConfirmPayout(
    @JsonProperty("Mtn") val mtn : String?,
    @JsonProperty("LocationCode") val locationCode : String?
)
