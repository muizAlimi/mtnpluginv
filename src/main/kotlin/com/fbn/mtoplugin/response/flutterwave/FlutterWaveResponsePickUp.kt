package com.fbn.mtoplugin.response.flutterwave

import Beneficiary
import Finance
import FlutterWaveSender
import com.google.gson.annotations.SerializedName

data class FlutterWaveResponsePickUp (
    @SerializedName("ResponseCode") val responseCode : String,
    @SerializedName("ResponseDesc") val responseDesc : String,
    @SerializedName("Sender") val sender : FlutterWaveSender,
    @SerializedName("Beneficiary") val beneficiary : Beneficiary,
    @SerializedName("Finance") val finance : Finance,
    @SerializedName("Status") var status: String,
    @SerializedName("TransactionReference") var transactionRef: String?
)
