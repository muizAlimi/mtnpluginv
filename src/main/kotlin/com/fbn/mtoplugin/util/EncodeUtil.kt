package com.fbn.mtoplugin.util

import org.springframework.stereotype.Component
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

@Component
class EncodeUtil {
    fun encodeMd5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val hashInBytes = md.digest(input.
        toByteArray(StandardCharsets.UTF_8))
        val sb = StringBuilder()
        for (b in hashInBytes) {
            sb.append(String.format("%02x", b))
        }
        return sb.toString()
    }

    fun encodeSha256(input: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-256")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    fun encodeSha1(input: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-1")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    fun encodeSha384(input: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-384")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    fun encodeSha512(input: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-512")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    fun simbaPaySignature(SecretKey: String, CompanyID: String, nonce: Long) : String {
        val key: String = "Merchant ID: "
        println("$key : $CompanyID")
        val keyVal: String = "Nonce value: "
        println("$keyVal : $nonce")
        println("Parameter Secret : $SecretKey")
        return (encodeSha256(nonce.toString() + CompanyID + SecretKey))
    }

    fun simbaPayNonce() : Long {
        val date: Date = Date()
        val nonceVal: Long = date.getTime()
        val key: String = "Nonce value: "
        println("$key : ${nonceVal}")
        return nonceVal
    }
}
