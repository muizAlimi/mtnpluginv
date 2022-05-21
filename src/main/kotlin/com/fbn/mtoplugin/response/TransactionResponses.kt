package com.fbn.mtoplugin.response

 data class CreateTransactionResponse(val responseCode :String,
                                      val responseMessage: String,
                                      val transactionBatchReference :String,
                                      val transactionContractReference :String,
                                      val transactionReference :String)
