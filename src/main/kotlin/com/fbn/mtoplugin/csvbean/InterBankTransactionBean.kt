package com.fbn.mtoplugin.csvbean

class InterBankTransactionBean {
    var amount: String? = null
    var destinationaccountnumber: String? = null
    var beneficiaryname: String? = null
    var sourceaccountnumber: String? = null
    var narration: String? = null
    var savebeneficiary: Boolean = false
    var destinationbankcode: String? = null
    var branchcode: String? = null

    override fun toString(): String {
        return "InterBankTransactionBean(amount=$amount, destinationaccountnumber=$destinationaccountnumber, beneficiaryname=$beneficiaryname, sourceaccountnumber=$sourceaccountnumber, narration=$narration, destinationbankcode=$destinationbankcode,savebeneficiary=$savebeneficiary)"
    }


}


