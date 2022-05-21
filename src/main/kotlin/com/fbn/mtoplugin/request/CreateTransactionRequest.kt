package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty

data class CreateTransactionRequest(
    @NotEmpty
    var transactionAmount: String?,
    @NotEmpty
    var transactionBatchReference: String?,
    @NotEmpty
    var transactionSenderBirthDate: String?,
    @NotEmpty
    var transactionCurrency: String?,
    @NotEmpty
    var transactionDate: String?,
    @NotEmpty
    var transactionDestinationCountryCode: String?,
    @NotEmpty
    var transactionDestinationCountryCurrency: String?,
    @NotEmpty
    var transactionMtoCode: String?,
    @NotEmpty
    var transactionNarration: String?,
    @NotEmpty
    var transactionPurposeCode: String?,
    @NotEmpty
    var transactionReceiverAccountNumber: String?,
    @NotEmpty
    var transactionReceiverBankCode: String?,
    @NotEmpty
    var transactionReceiverCity: String?,
    @NotEmpty
    var transactionReceiverEmailAddress: String?,
    @NotEmpty
    var transactionReceiverFirstName: String?,
    @NotEmpty
    var transactionReceiverGender: String?,
    @NotEmpty
    var transactionReceiverLastName: String?,
    @NotEmpty
    var transactionReceiverMiddleName: String?,
    @NotEmpty
    var transactionReceiverNationality: String?,
    @NotEmpty
    var transactionReceiverPhoneNumber: String?,
    @NotEmpty
    var transactionReceiverStreet: String?,
    @NotEmpty
    var transactionReference: String?,
    @NotEmpty
    var transactionSenderCityAddress: String?,
    @NotEmpty
    var transactionSenderEmailAddress: String?,
    @NotEmpty
    var transactionSenderFirstName: String?,
    @NotEmpty
    var transactionSenderGender: String?,
    @NotEmpty
    var transactionSenderIdExpiryDate: String?,
    @NotEmpty
    var transactionSenderIdIssueDate: String?,
    @NotEmpty
    var transactionSenderIdIssuer: String?,
    @NotEmpty
    var transactionSenderIdNumber: String?,
    @NotEmpty
    var transactionSenderIdType: String?,
    @NotEmpty
    var transactionSenderImage: String?,
    @NotEmpty
    var transactionSenderLastName: String?,
    @NotEmpty
    var transactionSenderMiddleName: String?,
    @NotEmpty
    var transactionSenderNationality: String?,
    @NotEmpty
    var transactionSenderOccupationCode: String?,
    @NotEmpty
    var transactionSenderPhoneNumber: String?,
    @NotEmpty
    var transactionSenderRelationship: String?,
    @NotEmpty
    var transactionSenderStreetAddress: String?,
    @NotEmpty
    var transactionSourceCode: String?,
    @NotEmpty
    var transactionSourceCountryCode: String?,
    @NotEmpty
    var transactionSourceCountryCurrency: String?,
    @NotEmpty
    var transactionTime: String?,
    @NotEmpty
    var transactionTransactionPurposeCode: String?
)