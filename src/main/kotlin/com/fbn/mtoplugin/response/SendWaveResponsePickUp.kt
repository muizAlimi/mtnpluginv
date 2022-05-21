package com.fbn.mtoplugin.response


import com.google.gson.annotations.SerializedName

data class SendWaveResponsePickUp(
    @SerializedName("confirmation_code")
    val confirmationCode: String?,
    @SerializedName("receive_amount")
    val receiveAmount: Double?,
    @SerializedName("receive_currency")
    val receiveCurrency: String?,
    @SerializedName("recipient_country")
    val recipientCountry: String?,
    @SerializedName("recipient_mobile")
    val recipientMobile: String?,
    @SerializedName("recipient_name")
    val recipientName: String?,
    @SerializedName("send_amount")
    val sendAmount: Double?,
    @SerializedName("send_currency")
    val sendCurrency: String?,
    @SerializedName("sender_country")
    val senderCountry: String?,
    @SerializedName("sender_name")
    val senderName: String?,
    @SerializedName("sender_state")
    val senderState: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("status_description")
    val statusDescription: String?,
    var responseCode: String?,
    var responseMessage: String?
)