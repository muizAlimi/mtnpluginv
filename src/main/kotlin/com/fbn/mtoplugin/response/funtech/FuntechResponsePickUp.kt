package com.fbn.mtoplugin.response.funtech

data class FuntechResponsePickUp(
    var ResponseCode: String?,
    var ResponseMessage: String?,
    var PayoutCurrency: String?,
    var PayoutPrincipal: Double?,
    var RecipientCity: String?,
    var RecipientFirstName: String?,
    var RecipientLastName: String?,
    var RecipientMobileNumber: String?,
    var SenderFirstName: String?,
    var SenderLastName: String?,
    var Status: String?,
    var transactionReference: String?
)
