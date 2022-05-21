package com.fbn.mtoplugin.response.firstapple

data class PayTransactionResponse(
    var Code: String?,
    var Detail: String?,
    var Message: String?

)data class PayTransactionErrorResponse(
    var Code: String?,
    var Detail: String?,
    var Message: List<String>?
)