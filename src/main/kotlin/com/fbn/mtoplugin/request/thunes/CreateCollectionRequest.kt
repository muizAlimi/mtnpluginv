package com.fbn.mtoplugin.request.thunes

data class CreateCollectionRequest(
    var branch: Branch?,
    var external_id: String?,
    var transaction_reference: String?
) {
    data class Branch(
        var address: String?,
        var city: String?,
        var code: String?,
        var country_iso_code: String?,
        var name: String?,
        var postal_code: String?
    )
}