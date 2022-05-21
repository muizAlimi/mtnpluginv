package com.fbn.mtoplugin.util

import java.io.File

interface EmailUtil {
    fun sendEmail(toAddress: String?, subject: String, body: String)
    fun twilloSendEmail(toAddress: String?, subject: String?, body: String?)
    fun sendEmail(toAddress: String, subject: String, body: String, files : List<File>)
}