package com.fbn.mtoplugin.request.firstapple

data class PayTransactionRequest(
    var ReceiverID: String?,
    var Remarks: String?,
    var TransferNO: String?
)