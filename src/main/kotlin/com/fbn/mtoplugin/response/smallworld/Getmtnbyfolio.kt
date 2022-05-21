package com.fbn.mtoplugin.response.smallworld

data class Return (
    val agentCode: String,
    val beneficiary: Beneficiary,
    val creationDate: String,
    val deliveryMethod: String,
    val fixedFee: String,
    val folioNumber: String,
    val mtn: String,
    val payerLocationCode: String,
    val payerMtn: String,
    val payoutCountry: String,
    val payoutCurrency: String,
    val payoutPrincipal: String,
    val pinNumber: String,
    val sender: Sender,
    val sendingCountry: String,
    val serviceMessage: String,
    val totalSale: String,
    val variableFee: String,
    val agentName: String,
    val amountOwed: String,
    val deliveryFee: String,
    val rate: String,
    val settlementAmount: String,
    val settlementCurrency: String
)

data class Beneficiary (
    val address: String,
    val bankAccountType: String,
    val city: String,
    val clientID: String,
    val country: String,
    val mobilePhoneCountry: String,
    val mobilePhoneNumber: String,
    val type: String,
    val zip: String,
    val firstLastName: String,
    val firstName: String,
    val gender: String,
    val secondLastName: String,
    val secondName: String
)

data class Sender (
    val city: String,
    val clientID: String,
    val country: String,
    val type: String,
    val dateOfBirth: String,
    val firstLastName: String,
    val firstName: String,
    val secondLastName: String,
    val secondName: String
)
