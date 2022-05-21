package com.fbn.mtoplugin.csvbean


class TransactionBean {
    var amount: String? = null
    var destinationaccountnumber: String? = null
    var beneficiaryname: String? = null
    var narration: String? = null
    var status: String? = null
    var savebeneficiary: Boolean = false
    var sourceaccountnumber: String? = null

    override fun toString(): String {
        return "TransactionBean(amount=$amount, destinationaccountnumber=$destinationaccountnumber, beneficiaryname=$beneficiaryname, narration=$narration, status=$status, sourceaccountnumber=$sourceaccountnumber)"
    }

}