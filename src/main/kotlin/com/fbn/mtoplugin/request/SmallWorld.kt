package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class GetTransExportByFolio(@NotEmpty(message = "folionumber is required") var folionumber : String?)
data class PayOutAnyWhereRequest(
    @NotEmpty(message = "transactionNumber is required") var transactionNumber : String?,
    @NotEmpty(message = "note is required") var note : String?,
    @NotEmpty(message = "locationCode is required") var locationCode : String?,
    @NotEmpty(message = "payerCode is required") var payerCode : String?
)
