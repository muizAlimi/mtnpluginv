package com.fbn.mtoplugin.response.simbapay

import Recipient
import FlutterWaveSender
import Sender
import Transaction
import com.google.gson.annotations.SerializedName

data class SimbaResultResponse(
    @SerializedName("status") val status : String,
    @SerializedName("error") val error : String,
    @SerializedName("sender") val sender : Sender,
    @SerializedName("recipient") val recipient : Recipient,
    @SerializedName("transaction") val transaction : Transaction
)
