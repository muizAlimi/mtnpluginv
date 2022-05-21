package com.fbn.mtoplugin.response.flutterwave

import com.google.gson.annotations.SerializedName

data class FlutterWavePaymentResponse(
    @SerializedName("ResponseCode") val responseCode : String,
    @SerializedName("ResponseDesc") val responseDesc : String,
    @SerializedName("TransactionRef") val transactionRef : String,
    @SerializedName("PaymentRef") val paymentRef : String
)
