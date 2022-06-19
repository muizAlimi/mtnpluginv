package com.fbn.mtoplugin.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fbn.mtoplugin.request.funtech.TransactionRequestPayout
import com.google.gson.annotations.SerializedName

data class ApiRequest(
    @JsonProperty("AccessAffiliateNumber") val accessAffiliateNumber : String,
    @JsonProperty("AccessServiceNumber") val accessServiceNumber : String,
    @JsonProperty("AccessUsername") val accessUsername : String,
    @JsonProperty("AccessPassword") val accessPassword : String,
    @JsonProperty("AccessHashData") val accessHashData : String,
    @JsonProperty("SpaTransactionRequestForPayout") val spaTransactionRequestForPayout : TransactionRequestPayout
)
