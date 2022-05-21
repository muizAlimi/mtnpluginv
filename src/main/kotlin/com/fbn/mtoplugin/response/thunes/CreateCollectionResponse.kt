package com.fbn.mtoplugin.response.thunes

import com.fbn.mtoplugin.request.thunes.ThunesTransaction

data class CreateCollectionResponse(
    var branch: Branch?,
    var creation_date: String?,
    var external_id: String?,
    var id: Int?,
    var status: String?,
    var status_class: String?,
    var status_class_message: String?,
    var status_message: String?,
    var transaction: Transaction?,
    var errors: List<Error>?
    ) {
    data class Error(
        var code: String?,
        var message: String?
        )
    data class Branch(
        var address: String?,
        var city: String?,
        var code: String?,
        var country_iso_code: String?,
        var name: String?,
        var postal_code: String?
    )

    data class Transaction(
        var beneficiary: Beneficiary?,
        var destination: Destination?,
        var purpose_of_remittance: String?,
        var sender: Sender?,
        var transaction_code: String?
    ) {
        data class Beneficiary(
            var address: String?,
            var bank_account_holder_name: String?,
            var city: String?,
            var code: Any?,
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
            var lastname2: Any?,
            var middlename: Any?,
            var msisdn: String?,
            var nationality_country_iso_code: String?,
            var nativename: Any?,
            var occupation: String?,
            var postal_code: String?,
            var province_state: Any?
        )

        data class Destination(
            var amount: Double?,
            var currency: String?
        )

        data class Sender(
            var address: String?,
            var beneficiary_relationship: Any?,
            var city: String?,
            var code: Any?,
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
            var lastname2: Any?,
            var middlename: Any?,
            var msisdn: String?,
            var nationality_country_iso_code: String?,
            var nativename: Any?,
            var occupation: String?,
            var postal_code: String?,
            var province_state: Any?,
            var source_of_funds: Any?
        )
    }
}