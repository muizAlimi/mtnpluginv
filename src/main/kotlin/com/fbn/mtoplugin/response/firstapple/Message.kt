package com.fbn.mtoplugin.response.firstapple

data class Message(
    var BeneficiaryFullName: String?,
    var ReceivedAmount: String?,
    var SenderFullName: String?,
    var TransactionStatus: String?,
    var TransferNo: String?
)