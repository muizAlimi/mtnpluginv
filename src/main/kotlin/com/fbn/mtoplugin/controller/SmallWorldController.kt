package com.fbn.mtoplugin.controller
import com.fbn.mtoplugin.extensions.toActualString
import com.fbn.mtoplugin.extensions.toDocument
import com.fbn.mtoplugin.extensions.toMTNByFolio
import com.fbn.mtoplugin.extensions.toXMLRequest
import com.fbn.mtoplugin.integrations.smallworld.SmallWorldServices
import com.fbn.mtoplugin.request.GetTransExportByFolio
import com.fbn.mtoplugin.request.PayOutAnyWhereRequest
import com.fbn.mtoplugin.util.ConfigUtil
import com.google.common.hash.Hashing
import com.google.common.hash.Hashing.*
import org.json.XML
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.Charset
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/smallworld")
class SmallWorldController(private val smallWorldServices: SmallWorldServices,
                           private val configUtil: ConfigUtil) {

    @PostMapping("/getmtnbyfolio")
    fun getTransactionByFolio(@Valid @RequestBody getMtn: GetTransExportByFolio) : ResponseEntity<*> {
        val config = configUtil.getCredentialsByMto("smallworld")
        val password = sha1().hashString(config["password"]!!, Charset.defaultCharset());
        val response = smallWorldServices.callSmallWorld(getMtn.folionumber!!.toMTNByFolio(config["username"]!!, "$password")).toDocument()
        val resp  = response.getElementsByTagName("return")
        val output = resp.item(0).toActualString()
        val jsonObj = XML.toJSONObject(output)
        val responseObject = jsonObj.getString("return")
        println(responseObject)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/gettransactionexportbymtn")
    fun getTransactionExportByMtn(@Valid @RequestBody getTransExportByFolio: GetTransExportByFolio, errors: Errors) : ResponseEntity<*> {
        if (errors.hasErrors()) throw IllegalStateException(errors.allErrors.map { it.defaultMessage }.joinToString("; "))
        val mtnString = smallWorldServices.getMtnByFolioNumber(getTransExportByFolio.folionumber!!)
        mtnString ?: throw IllegalStateException("unable to get MTN")
        if (mtnString == "0") throw IllegalStateException("transaction not found")
        val config = configUtil.getCredentialsByMto("smallworld")
        val password = sha1().hashString(config["password"]!!, Charset.defaultCharset());
        val response = smallWorldServices.callSmallWorld(mtnString.toXMLRequest(config["username"]!!, "$password")).toDocument()
        val resp = response.getElementsByTagName("return")
        val output = resp.item(0).toActualString()
        val jsonObj = XML.toJSONObject(output)
        val responseObject = jsonObj.getJSONObject("return")
        responseObject.put("responseCode", "00")
        responseObject.put("responseMessage", "Success")
        return ResponseEntity(responseObject.toString(),  HttpStatus.OK)
    }







}