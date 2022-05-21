package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class PickupRequest(
    @NotEmpty(message = "transactionMtoCode is required")
    var TransactionMtoCode: String?,
    @NotEmpty(message = "transactionReference is required")
    var TransactionReference: String?
)

data class TSQRequest(@NotEmpty(message = "transactionReference is required") var TransactionReference: String?,
                      @NotEmpty(message = "transactionMtoCode is required") var TransactionMtoCode: String?)


data class ReadTSQResponse(
    var responseCode: String?,
    var responseMessage: String?,
    var transactionStatus: String?
)