package com.fbn.mtoplugin.request.funtech

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.fbn.mtoplugin.request.ApiRequest

data class FunTechRequestPayout(
    @JsonProperty("ApiRequest") val apiRequest : ApiRequest
)
