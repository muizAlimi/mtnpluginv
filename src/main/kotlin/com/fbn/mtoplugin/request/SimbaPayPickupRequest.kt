package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class SimbaPayPickupRequest(
    @NotEmpty(message = "transaction reference is required") var transactionReference: String?
)

data class SimbaPayCompletePickupRequest(
    @NotEmpty(message = "note is required") var notes : String?,
    @NotEmpty(message = "transaction reference is required") var transactionReference: String?,
    var tellerID : String?
)

data class HoldPickupRequest(
    @NotEmpty(message = "action is required") var action : String?,
    @NotEmpty(message = "tellerID is required") var tellerID : String?,
    @NotEmpty(message = "transaction reference is required") var transactionReference: String?,
)
