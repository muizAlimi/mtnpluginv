package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class FlutterWavePickupRequest(
    @NotEmpty(message = "transaction reference is required") var transactionReference: String
)
data class FlutterWaveCompletePickupRequest(
    @NotEmpty(message = "payment reference is required") var PaymentRef: String,
    @NotEmpty(message = "bank reference is required") var BankRef: String,
    @NotEmpty(message = "token is required") var OTP: String

)
