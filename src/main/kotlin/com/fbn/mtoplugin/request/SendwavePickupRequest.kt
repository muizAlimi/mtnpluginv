package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class SPickupRequest(
    @NotEmpty(message = "transactionMtoCode is required")
    var TransactionMtoCode: String?,
    @NotEmpty(message = "transactionReference is required")
    var TransactionReference: String?
)

data class LockPickupRequest(
    @NotEmpty(message = "transactionMtoCode is required")
    var TransactionMtoCode: String?,
    @NotEmpty(message = "transactionReference is required")
    var TransactionReference: String?,
    @NotEmpty(message = "BranchCode is required")
    var BranchCode: String?,
    @NotEmpty(message = "EmployeeID is required")
    var EmployeeID: String?
)

data class CompletePickupRequest(
    @NotEmpty(message = "transactionMtoCode is required")
    var TransactionMtoCode: String?,
    @NotEmpty(message = "transactionReference is required")
    var TransactionReference: String?,
    @NotEmpty(message = "TrackID is required")
    var TrackID: String?,
    @NotEmpty(message = "BranchCode is required")
    var BranchCode: String?,
    @NotEmpty(message = "EmployeeID is required")
    var EmployeeID:String?,
    @NotEmpty(message = "OTP is required")
    var OTP:String?,
)