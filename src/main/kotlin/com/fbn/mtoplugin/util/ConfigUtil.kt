package com.fbn.mtoplugin.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ConfigUtil {

    @Value("\${fapple.dev.key}")
    private val FIRST_APPLE_KEY_DEV : String? = null
    @Value("\${fapple.dev.payeecode}")
    private val FIRST_APPLE_PAYEECODE_DEV : String? = null
    @Value("\${fapple.dev.baseurl}")
    private val FIRST_APPLE_BASEURL_DEV : String? = null

    @Value("\${smallworld.dev.password}")
    private val SMALL_WORLD_PASSWORD_DEV : String? = null
    @Value("\${smallworld.dev.baseurl}")
    private val SMALL_WORLD_BASEURL_DEV : String? = null
    @Value("\${smallworld.dev.integrationid}")
    private val SMALL_WORLD_INTEGRATIONID_DEV : String? = null


    @Value("\${idtps.dev.password}")
    private val IDTPS_PAYERS_CODE_DEV : String? = null
    @Value("\${idtps.dev.baseurl}")
    private val IDTPS_BASEURL_DEV : String? = null
    @Value("\${idtps.dev.integrationid}")
    private val IDTPS_USER_CODE_DEV : String? = null
    @Value("\${idtps.dev.key}")
    private val IDTPS_INTEGRATION_ID_DEV : String? = null

    @Value("\${simbapay.dev.secret}")
    private val SIMBA_PAY_SECRET_DEV : String? = null
    @Value("\${simbapay.dev.companyid}")
    private val SIMBA_PAY_COMPANYID_DEV : String? = null
    @Value("\${simbapay.dev.baseurl}")
    private val SIMBA_PAY_BASEURL_DEV : String? = null

    @Value("\${flutterwave.dev.clientsecret}")
    private val FLUTTER_WAVE_CLIENTSECRET_DEV : String? = null
    @Value("\${flutterwave.dev.clientid}")
    private val FLUTTER_WAVE_CLIENTID_DEV : String? = null
    @Value("\${flutterwave.dev.baseurl}")
    private val FLUTTER_WAVE_BASEURL_DEV : String? = null


    @Value("\${fapple.prod.key}")
    private val FIRST_APPLE_KEY_PROD : String? = null
    @Value("\${fapple.prod.payeecode}")
    private val FIRST_APPLE_PAYEECODE_PROD : String? = null
    @Value("\${fapple.prod.baseurl}")
    private val FIRST_APPLE_BASEURL_PROD : String? = null

    @Value("\${smallworld.prod.password}")
    private val SMALL_WORLD_PASSWORD_PROD : String? = null
    @Value("\${smallworld.prod.baseurl}")
    private val SMALL_WORLD_BASEURL_PROD : String? = null
    @Value("\${smallworld.prod.integrationid}")
    private val SMALL_WORLD_INTEGRATIONID_PROD : String? = null


    @Value("\${idtps.prod.password}")
    private val IDTPS_PAYERS_CODE_PROD: String? = null
    @Value("\${idtps.prod.baseurl}")
    private val IDTPS_BASEURL_PROD : String? = null
    @Value("\${idtps.prod.integrationid}")
    private val IDTPS_USER_CODE_PROD : String? = null
    @Value("\${idtps.prod.key}")
    private val IDTPS_INTEGRATION_ID_PROD : String? = null

    @Value("\${simbapay.prod.secret}")
    private val SIMBA_PAY_SECRET_PROD : String? = null
    @Value("\${simbapay.prod.companyid}")
    private val SIMBA_PAY_COMPANYID_PROD : String? = null
    @Value("\${simbapay.prod.baseurl}")
    private val SIMBA_PAY_BASEURL_PROD : String? = null

    @Value("\${flutterwave.dev.clientsecret}")
    private val FLUTTER_WAVE_CLIENTSECRET_PROD : String? = null
    @Value("\${flutterwave.dev.clientid}")
    private val FLUTTER_WAVE_CLIENTID_PROD : String? = null
    @Value("\${flutterwave.dev.baseurl}")
    private val FLUTTER_WAVE_BASEURL_PROD : String? = null


    @Value("\${mto.stage}")
    private val STAGE : String? = null



    fun getCredentialsByMto(mto : String, stage : String = STAGE!!) : HashMap<String, String>{
        return when{
            mto == "idtps" && stage == "dev" -> {
                hashMapOf(
                    "payerscode" to IDTPS_PAYERS_CODE_DEV!!,
                    "baseurl" to IDTPS_BASEURL_DEV!!,
                    "usercode" to IDTPS_USER_CODE_DEV!!,
                    "integrationid" to IDTPS_INTEGRATION_ID_DEV!!,
                )
            }
            mto == "smallworld" && stage == "dev" -> {
                hashMapOf(
                    "password" to SMALL_WORLD_PASSWORD_DEV!!,
                    "baseurl" to SMALL_WORLD_BASEURL_DEV!!,
                    "username" to SMALL_WORLD_INTEGRATIONID_DEV!!,
                )
            }
            mto == "fapple" && stage == "dev" -> {
                hashMapOf(
                    "token" to FIRST_APPLE_KEY_DEV!!,
                    "payeecode" to FIRST_APPLE_PAYEECODE_DEV!!,
                    "baseurl" to FIRST_APPLE_BASEURL_DEV!!,
                )
            }
            mto == "simbapay" && stage == "dev" -> {
                hashMapOf(
                    "secret" to SIMBA_PAY_SECRET_DEV!!,
                    "companyid" to SIMBA_PAY_COMPANYID_DEV!!,
                    "baseurl" to SIMBA_PAY_BASEURL_DEV!!,
                )
            }
            mto == "flutterwave" && stage == "dev" -> {
                hashMapOf(
                    "clientsecret" to FLUTTER_WAVE_CLIENTSECRET_DEV!!,
                    "clientid" to FLUTTER_WAVE_CLIENTID_DEV!!,
                    "baseurl" to FLUTTER_WAVE_BASEURL_DEV!!,
                )
            }
            mto == "idtps" && stage == "prod" -> {
                hashMapOf(
                    "payerscode" to IDTPS_PAYERS_CODE_PROD!!,
                    "baseurl" to IDTPS_BASEURL_PROD!!,
                    "usercode" to IDTPS_USER_CODE_PROD!!,
                    "integrationid" to IDTPS_INTEGRATION_ID_PROD!!,
                )
            }
            mto == "smallworld" && stage == "prod" -> {
                hashMapOf(
                    "password" to SMALL_WORLD_PASSWORD_PROD!!,
                    "baseurl" to SMALL_WORLD_BASEURL_PROD!!,
                    "username" to SMALL_WORLD_INTEGRATIONID_PROD!!,
                )
            }
            mto == "fapple" && stage == "prod" -> {
                hashMapOf(
                    "token" to FIRST_APPLE_KEY_PROD!!,
                    "payeecode" to FIRST_APPLE_PAYEECODE_PROD!!,
                    "baseurl" to FIRST_APPLE_BASEURL_PROD!!,
                )
            }
            mto == "simbapay" && stage == "prod" -> {
                hashMapOf(
                    "secret" to SIMBA_PAY_SECRET_PROD!!,
                    "companyid" to SIMBA_PAY_COMPANYID_PROD!!,
                    "baseurl" to SIMBA_PAY_BASEURL_PROD!!,
                )
            }
            mto == "flutterwave" && stage == "prod" -> {
                hashMapOf(
                    "clientsecret" to FLUTTER_WAVE_CLIENTSECRET_PROD!!,
                    "clientid" to FLUTTER_WAVE_CLIENTID_PROD!!,
                    "baseurl" to FLUTTER_WAVE_BASEURL_PROD!!,
                )
            }
            else -> throw IllegalStateException("mto and stage not found")
        }
    }


}