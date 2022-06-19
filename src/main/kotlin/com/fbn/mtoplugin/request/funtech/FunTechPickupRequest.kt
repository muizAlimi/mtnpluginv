package com.fbn.mtoplugin.request.funtech

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class FunTechPickupRequest(
    @JsonProperty("ApiRequest") val apiRequest : ApiRequest
)
