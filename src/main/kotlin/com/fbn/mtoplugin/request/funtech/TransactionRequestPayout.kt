package com.fbn.mtoplugin.request.funtech

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import java.util.*

data class TransactionRequestPayout(
    @JsonProperty("Mtn") val mtn : String?,
    @JsonProperty("LocationCode") val locationCode : String?,
    @JsonProperty("PayerReference") val payerReference : String?,
    @JsonProperty("RecipientDob") val recipientDob : String?,
    @JsonProperty("RecipientIDDocumentCountryCodeISO") val recipientIDDocumentCountryCodeISO : String?,
    @JsonProperty("RecipientIDDocumentNumber") val recipientIDDocumentNumber : String?,
    @JsonProperty("RecipientIDDocumentTypeCode") val recipientIDDocumentTypeCode : String?,
    @JsonProperty("RecipientIDDocumentExpirationDate") val recipientIDDocumentExpirationDate : String?,
    @JsonProperty("RecipientIDDocumentDeliveryDate") val recipientIDDocumentDeliveryDate : String?
)
