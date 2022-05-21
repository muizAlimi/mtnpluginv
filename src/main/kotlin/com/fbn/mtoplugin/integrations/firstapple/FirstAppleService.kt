package com.fbn.mtoplugin.integrations.firstapple

import com.fbn.mtoplugin.extensions.toPayResponse
import com.fbn.mtoplugin.extensions.toTransaction
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.request.firstapple.PayTransactionRequest
import com.fbn.mtoplugin.request.firstapple.TransactionHistoryRequest
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.firstapple.*
import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class FirstAppleService(private val apiCaller: ApiCaller,
                        private val configUtil: ConfigUtil) {

    private val directCreditUrl = "https://4paek6rxxc.execute-api.us-east-1.amazonaws.com"
    private val version = "v1"

    fun getTransaction(transferNo : String?): PickupResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("fapple")
        val key = "${fAppleConfig["token"]}:${this.getAuthKey().Message}"
        val tokenHeader = hashMapOf("firsthead" to "Authentication", "firstheadkey" to key)
        val methodName = "gettransaction"
        val payeeCode = "Firstbank"
        val resp = this.apiCaller.getStringCall("${fAppleConfig["baseurl"]}/transaction?method_name=$methodName&transferno=$transferNo&payeecode=$payeeCode", tokenHeader)
        return Gson().fromJson(resp, GetTransactionResponse::class.java).toTransaction("fapple")
    }



    fun getAllUnpaidTransactions(): GetUnpaidTransactionResponse {
        val TransferNo = "all"
        val MethodName = "getttransaction"
        val PayeeCode = "93773"
        val response = """
            [
              {
                "SendDate": "2017-08-16T01:05:11.18Z",
                "InoiceNumber": "503466",
                "TransferNo": "503466",
                "SenderFirstName": "GRIGORYAN",
                "SenderMiddleName": "",
                "SENDERMOTHERMAIDENNAME": "",
                "SenderLastName": "VERIK",
                "SenderAddress": "GULBINOVIChA 30-19",
                "SenderPhone": "164600000",
                "SenderCity": "LOS ANGELES",
                "SenderState": "CALIFORNIA",
                "SenderCountry": "UNITED STATES",
                "ReceiverFirstName": "KARAPETYAN",
                "ReceiverMiddleName": "",
                "ReceiverLastName": "SEDA",
                "ReceiverMotherMaidenName": "",
                "ReceiverAddress": "G.GYuMRI",
                "ReceiverPhone": "374-98516814",
                "ReceiverCity": "Any City",
                "ReceiverState": " NIGERIA ",
                "ReceiverCountry": "NIGERIA",
                "Status": "Unpaid",
                "CancelledDate": null,
                "PaidDate": null,
                "Bank": "",
                "BankBranch": "",
                "BankAccount": "",
                "BankCode": "",
                "AccountType": "",
                "DeliverMethod": "CASH PICKUP",
                "ReceivedAmount": 10.00,
                "ReceivedCurrencyName": "Naira",
                "ReceivedCurrencyCode": "NGN",
                "PayoutLocationName": "TESTLOCATION",
                "PayoutLocationAddress": "12 Str. Office #1",
                "PayoutLocationZip": "00000",
                "PayoutLocationPhone": "+234 00000000",
                "PayoutLocationCity": "Any City",
                "PayoutLocationState": "NIGERIA",
                "PayoutLocationCountry": " NIGERIA ",
                "CustomerFee": 1.00,
                "SenderCountryCode": "USA",
                "ReceiverCountryCode": "NGA",
                "SendAmount": 10.00,
                "SendCurrencyCode": "USD",
                "SendCurrencyName": "Dollar",
                "ConversionRate": 1.00,
                "Code": 1,
                "Message": "Success",
                "DynamicResult": "GRIGORYAN,VERIK,503466"
              },
              {
                "SendDate": "2017-12-13T14:07:51.2Z",
                "InoiceNumber": "980095843210",
                "TransferNo": "980095843210",
                "SenderFirstName": "SID",
                "SenderMiddleName": "",
                "SENDERMOTHERMAIDENNAME": "",
                "SenderLastName": "SAM",
                "SenderAddress": "THIS IS SENDER",
                "SenderPhone": "88885574444",
                "SenderCity": "ABBEVILLE",
                "SenderState": "ALABAMA",
                "SenderCountry": "UNITED STATES",
                "ReceiverFirstName": "KID",
                "ReceiverMiddleName": "MID",
                "ReceiverLastName": "KAM",
                "ReceiverMotherMaidenName": "",
                "ReceiverAddress": "THIS IS THE RECEIVER",
                "ReceiverPhone": "000088888899",
                "ReceiverCity": "YEREVAN",
                "ReceiverState": "ARMENIA",
                "ReceiverCountry": "ARMENIA",
                "Status": "Unpaid",
                "CancelledDate": null,
                "PaidDate": null,
                "Bank": "",
                "BankBranch": "",
                "BankAccount": "",
                "BankCode": "",
                "AccountType": "",
                "DeliverMethod": "CASH PICKUP",
                "ReceivedAmount": 12.57,
                "ReceivedCurrencyName": "Dollar",
                "ReceivedCurrencyCode": "USD",
                "PayoutLocationName": "TESTLOCATION - REPUBLIC OF ARMENIA",
                "PayoutLocationAddress": "12 Vahram Papazyan Str. Office #1",
                "PayoutLocationZip": "00000",
                "PayoutLocationPhone": "+374 10 27-72-85",
                "PayoutLocationCity": "YEREVAN",
                "PayoutLocationState": "ARMENIA",
                "PayoutLocationCountry": "ARMENIA",
                "CustomerFee": 3,
                "SenderCountryCode": "USA",
                "ReceiverCountryCode": "PAK",
                "SendAmount": 12.57,
                "SendCurrencyCode": "USD",
                "SendCurrencyName": "Dollar",
                "ConversionRate": 1,
                "Code": 0,
                "Message": null,
                "DynamicResult": "SID,SAM,980095843210"
              }
            ]
        """.trimIndent()
        return Gson().fromJson(response, GetUnpaidTransactionResponse::class.java)
    }

    fun confirmTransaction(): ConfirmTransactionResponse {
        val TransferNo = "all"
        val MethodName = "getttransaction"
        val PayeeCode = "93773"
        val resp = this.apiCaller.postStringCall("$directCreditUrl/$version/imto/createDirectCredit", "", hashMapOf("firsthead" to "Authorization"))
        return Gson().fromJson(resp, ConfirmTransactionResponse::class.java)
    }

    fun getAuthKey(): AuthenticationResponse {
        val fAppleConfig = configUtil.getCredentialsByMto("fapple")
        val token = hashMapOf("firsthead" to "Authentication", "firstheadkey" to "")
        val response = apiCaller.getStringCall("${fAppleConfig["baseurl"]}/token?id=${fAppleConfig["token"]}", token)
        return Gson().fromJson(response, AuthenticationResponse::class.java)
    }



    fun payTransaction(payTransRequest: PayTransRequest): BaseResponse {
        val notAvailable = getTransaction(payTransRequest.transactionReference).ResponseCode != "00"
        if (notAvailable) throw IllegalStateException("transaction not available for payment")
        val recieverIdNumber = payTransRequest.transactionReceiverId ?: ""
        val paymentRef = payTransRequest.transactionReference ?: throw IllegalStateException("transactionReference is required")
        val payTransactionRequest =  PayTransactionRequest(recieverIdNumber, "Paid", payTransRequest.transactionReference)
        val fAppleConfig = configUtil.getCredentialsByMto("fapple")
        val request = Gson().toJson(payTransactionRequest)
        val key = "${fAppleConfig["token"]}:${this.getAuthKey().Message}"
        val fbn = fAppleConfig["payeecode"]
        val token = hashMapOf("firsthead" to "Authentication", "firstheadkey" to key)
        val resp = this.apiCaller.postStringCall("${fAppleConfig["baseurl"]}/transaction?method_name=PayTransaction&TransferNo=$paymentRef&payeecode=$fbn",request, token)
        return when{
            resp!!.contains("[") -> Gson().fromJson(resp, PayTransactionErrorResponse::class.java).toPayResponse()
            else -> Gson().fromJson(resp, PayTransactionResponse::class.java).toPayResponse()
        }
    }

//    fun getAllReceiverTransactionHistory(historyRequest: TransactionHistoryRequest): TransactionHistoryResponse? {
//        val request = Gson().toJson(historyRequest)
//        val resp = this.apiCaller.postStringCall("$directCreditUrl/$version/imto/createDirectCredit", request, hashMapOf("firsthead" to "Authorization"))
//        return Gson().fromJson(resp, TransactionHistoryResponse::class.java)
//    }








}