package com.fbn.mtoplugin.request.funtech

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.fbn.mtoplugin.request.firstapple.ApiRequest

data class FunTechConfirmPayout(
    @JsonProperty("ApiRequest") val apiRequest : ApiRequest
)
