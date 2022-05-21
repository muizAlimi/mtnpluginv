package com.fbn.mtoplugin.request.thunes

import com.fbn.mtoplugin.response.thunes.CreateCollectionResponse


data class ThunesTransaction(
    var beneficiary: Beneficiary?,
    var destination: Destination?,
    var purpose_of_remittance: String?,
    var sender: Sender?,
    var transaction_code: String?,
    var errors: List<Error>?
    ) {
    data class Error(
        var code: String?,
        var message: String?
    )
    data class Beneficiary(
        var address: String?,
        var bank_account_holder_name: String?,
        var city: String?,
        var code: String?,
        var country_iso_code: String?,
        var country_of_birth_iso_code: String?,
        var date_of_birth: String?,
        var email: String?,
        var firstname: String?,
        var gender: String?,
        var id_country_iso_code: String?,
        var id_delivery_date: Any?,
        var id_expiration_date: Any?,
        var id_number: String?,
        var id_type: String?,
        var lastname: String?,
        var lastname2: String?,
        var middlename: String?,
        var msisdn: String?,
        var nationality_country_iso_code: String?,
        var nativename: String?,
        var occupation: String?,
        var postal_code: String?,
        var province_state: String?
    )

    data class Destination(
        var amount: Double?,
        var currency: String?
    )

    data class Sender(
        var address: String?,
        var beneficiary_relationship: Any?,
        var city: String?,
        var code: String?,
        var country_iso_code: String?,
        var country_of_birth_iso_code: String?,
        var date_of_birth: String?,
        var email: String?,
        var firstname: String?,
        var gender: String?,
        var id_country_iso_code: Any?,
        var id_delivery_date: String?,
        var id_expiration_date: Any?,
        var id_number: String?,
        var id_type: String?,
        var lastname: String?,
        var lastname2: String?,
        var middlename: String?,
        var msisdn: String?,
        var nationality_country_iso_code: String?,
        var nativename: Any?,
        var occupation: String?,
        var postal_code: String?,
        var province_state: Any?,
        var source_of_funds: Any?
    )
}