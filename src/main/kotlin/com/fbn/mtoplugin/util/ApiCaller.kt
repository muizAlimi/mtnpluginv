package com.fbn.mtoplugin.util


interface ApiCaller {

    fun postStringCall(uri: String, request: HashMap<String, Any>, token: String): HashMap<String, Any?>

    fun postStringCall(uri: String?, request: HashMap<String?, Any?>?, token: HashMap<String?, Any?>?): HashMap<String, Any?>?

    fun postStringCall(uri: String?, request: String?, token: HashMap<String, String>): String?

    fun getStringCall(uri: String, token: HashMap<String, String>, username : String? = null, password : String? = null): String?

    fun postStringCall(uri: String?, request: String?): String?

    fun postStringCall(uri: String, request: String, token: String): String

    fun getStringCall(uri: String,  username: String, password: String?, params: Map<String, String>): String?

    fun postStringCall(uri: String,  body : String?, username: String, password: String?, params: Map<String, String>): String?

    fun getSimPayCall(uri: String, nonce: HashMap<String, String>, token: HashMap<String, String>, company: HashMap<String, String>): String?

    fun postSimPayCall(uri: String, nonce: HashMap<String, String>, token: HashMap<String, String>, company: HashMap<String, String>, request: String): String?

    fun putSimPayCall(uri: String, nonce: HashMap<String, String>, token: HashMap<String, String>, company: HashMap<String, String>, request: String): String?

    fun getAuthCall(uri: String, request: String): String?

    fun getFlutterwaveCall(uri: String, token: HashMap<String, String>, request: String): String?

    fun postFlutterwaveCall(uri: String, token: HashMap<String, String>, request: String): String?

    fun getFlutterwaveQueryCall(uri: String, token: HashMap<String, String>): String?

}