package com.fbn.mtoplugin.extensions

import com.fbn.mtoplugin.gatewayresponse.smallword.MtnByFolioGatewayResponse
import com.fbn.mtoplugin.request.CreateTransactionRequest
import com.fbn.mtoplugin.request.GetTransExportByFolio
import com.fbn.mtoplugin.request.PayTransRequest
import com.fbn.mtoplugin.request.firstapple.PayTransactionRequest
import com.fbn.mtoplugin.request.thunes.CreateCollectionRequest
import com.fbn.mtoplugin.request.thunes.ThunesTransaction
import com.fbn.mtoplugin.response.BaseResponse
import com.fbn.mtoplugin.response.PickupResponse
import com.fbn.mtoplugin.response.SendWaveResponsePickUp
import com.fbn.mtoplugin.response.firstapple.GetTransactionResponse
import com.fbn.mtoplugin.response.firstapple.PayTransactionErrorResponse
import com.fbn.mtoplugin.response.firstapple.PayTransactionResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWavePaymentResponse
import com.fbn.mtoplugin.response.flutterwave.FlutterWaveResponsePickUp
import com.fbn.mtoplugin.response.idtps.LookupResponse
import com.fbn.mtoplugin.response.idtps.PaymentResponse
import com.fbn.mtoplugin.response.idtps.ReleaseResponse
import com.fbn.mtoplugin.response.idtps.ReservationResponse
import com.fbn.mtoplugin.response.simbapay.GetTransactionStatus
import com.fbn.mtoplugin.response.simbapay.SimbaTransactionResponse
import com.google.gson.Gson
import org.apache.commons.lang3.StringEscapeUtils
import org.json.JSONObject
import org.json.XML
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.StringReader
import java.io.StringWriter
import java.time.LocalDateTime
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun MtnByFolioGatewayResponse.toTransaction(mtoCode : String): PickupResponse{
    return PickupResponse().apply {
            ResponseCode = responseCode; ResponseMessage = responseMessage; TransactionAmount = settlementAmount.toString();
        TransactionSenderBirthDate = sender?.dateOfBirth; TransactionSenderCityAddress = sender?.city;
        TransactionSenderFirstName = sender?.firstName; TransactionSenderLastName = sender?.firstLastName;
        TransactionReceiverCity = beneficiary?.city; TransactionReceiverFirstName = beneficiary?.firstName
        TransactionMtoCode = mtoCode; TransactionReference = "$folioNumber"; TransactionCurrency = settlementCurrency ?: "USD"
        TransactionDestinationCountryCurrency = settlementCurrency ?: "USD"; TransactionSourceCountryCurrency = settlementCurrency ?: "USD"
        TransactionDate = creationDate ?: ""; TransactionReceiverLastName = beneficiary?.firstLastName
    }
}


fun SendWaveResponsePickUp.toTransaction(mtoCode : String): PickupResponse{
    return PickupResponse().apply {
            ResponseCode = responseCode; ResponseMessage = responseMessage; TransactionAmount = receiveAmount.toString();
            TransactionReceiverFirstName = recipientName; TransactionReference = confirmationCode;
            TransactionSenderFirstName = senderName; TransactionStatus = statusDescription;
            TransactionReceiverPhoneNumber = recipientMobile; TransactionReceiverNationality = recipientCountry
            TransactionSourceCountryCurrency = sendCurrency; TransactionDestinationCountryCurrency = receiveCurrency;
            TransactionMtoCode = mtoCode; TransactionCurrency = receiveCurrency ?: "USD"
            TransactionDestinationCountryCurrency = receiveCurrency ?: "USD"; TransactionSourceCountryCurrency = receiveCurrency ?: "USD"


    }
}

fun FlutterWaveResponsePickUp.toTransaction(mtoCode : String): PickupResponse{
    return PickupResponse().apply {
        ResponseCode = responseCode; ResponseMessage = responseDesc;
        TransactionAmount = finance?.receiveAmount.toString();
        TransactionReceiverFirstName = beneficiary?.firstName; TransactionReceiverPhoneNumber = beneficiary?.phoneNo;
        TransactionReceiverLastName = beneficiary?.lastName; TransactionReceiverAddress = beneficiary?.address1;
        TransactionReceiverCity = beneficiary?.state; TransactionReceiverNationality = beneficiary?.country;
        TransactionSenderFirstName = sender?.firstName; TransactionSenderLastName = beneficiary?.lastName;
        TransactionSenderPhoneNumber = sender?.phoneNo; TransactionSenderStreetAddress = sender?.address1;
        TransactionSenderCityAddress = sender?.state; TransactionSenderNationality = sender?.country;
        TransactionStatus = status; TransactionReference = transactionRef;
        TransactionSourceCountryCurrency = finance?.sendCurrency; TransactionDestinationCountryCurrency = finance?.receiveCurrency;
        TransactionMtoCode = mtoCode; TransactionCurrency = finance?.receiveCurrency ?: "USD"
        TransactionDestinationCountryCurrency = finance?.receiveCurrency ?: "USD"; TransactionSourceCountryCurrency = finance?.sendCurrency ?: "USD"


    }
}


fun ThunesTransaction.toTransaction(mtoCode : String): PickupResponse{
    val responsecode = if(this.sender != null) Pair("00", "success") else Pair("95", "not found")
    val resonseobject = this
    return PickupResponse().apply {
        TransactionReference = resonseobject.transaction_code
        TransactionMtoCode = mtoCode
        ResponseCode = responsecode.first
        ResponseMessage= responsecode.second
        TransactionReceiverCity = resonseobject.beneficiary?.city
        TransactionReceiverFirstName = resonseobject.beneficiary?.firstname
        TransactionReceiverGender = resonseobject.beneficiary?.gender
        TransactionReceiverEmailAddress = resonseobject.beneficiary?.email
        TransactionReceiverNationality = resonseobject.beneficiary?.nationality_country_iso_code
        TransactionReceiverPhoneNumber = resonseobject.beneficiary?.msisdn
        TransactionReceiverLastName = resonseobject.beneficiary?.lastname
        TransactionReceiverLastName = resonseobject.beneficiary?.lastname
        TransactionReceiverStreet = resonseobject.beneficiary?.address
        TransactionReceiverBirthDate = resonseobject.beneficiary?.date_of_birth
        TransactionReceiverAddress = resonseobject.beneficiary?.address
        TransactionSenderBirthDate = resonseobject.sender?.date_of_birth
        TransactionSenderCityAddress = resonseobject.sender?.address
        TransactionSenderFirstName = resonseobject.sender?.firstname
        TransactionSenderGender = resonseobject.sender?.gender
        TransactionSenderEmailAddress = resonseobject.sender?.email
        TransactionSenderIdIssueDate = resonseobject.sender?.id_delivery_date
        TransactionSenderLastName = resonseobject.sender?.lastname
        TransactionSenderIdNumber = resonseobject.sender?.id_number
        TransactionSenderNationality = resonseobject.sender?.nationality_country_iso_code
        TransactionSenderPhoneNumber = resonseobject.sender?.msisdn
        TransactionAmount = resonseobject.destination?.amount.toString()
        TransactionCurrency = resonseobject.destination?.currency ?: "USD"
        TransactionDestinationCountryCode = resonseobject.beneficiary?.country_iso_code
        TransactionDestinationCountryCurrency = resonseobject.destination?.currency ?: "USD"
        TransactionId = resonseobject.transaction_code
        TransactionNarration = resonseobject.purpose_of_remittance
    }
}

fun GetTransactionResponse.toTransaction(mtoCode : String) : PickupResponse{
    val responseCode = if((resultModel?.Code).toString() == "1") "00" else resultModel?.Code.toString()
    val responseMessage = resultModel?.Message ?: "no response from server"
    return PickupResponse().apply {
        ResponseCode = responseCode; ResponseMessage = responseMessage;TransactionAmount = resultModel?.ReceivedAmount.toString()
        TransactionReceiverFirstName = resultModel?.ReceiverFirstName; TransactionReceiverLastName = resultModel?.ReceiverLastName;
        TransactionReference = resultModel?.TransferNo; TransactionSenderFirstName = resultModel?.SenderFirstName;
        TransactionSenderLastName = resultModel?.SenderLastName; TransactionStatus = resultModel?.Status;
        TransactionSenderCityAddress = resultModel?.SenderAddress; TransactionDestinationCountryCurrency= resultModel?.ReceivedCurrencyCode ?: "USD"
        TransactionCurrency = resultModel?.SendCurrencyCode ?: "USD"; TransactionMtoCode = mtoCode; TransactionSenderNationality = resultModel?.SenderCountry
        TransactionReceiverNationality = resultModel?.ReceiverCountry; TransactionSenderPhoneNumber = resultModel?.SenderPhone
        TransactionReceiverPhoneNumber = resultModel?.ReceiverPhone; TransactionDate = resultModel?.SendDate
    }
}

fun SimbaTransactionResponse.toTransaction(mtoCode : String): PickupResponse{
    val responseCode = if((resultModel?.status).toString() == "OK") "00" else resultModel?.status.toString()
    val responseMessage = resultModel?.error ?: "Response is good, proceed as expected"
    if(responseCode == "00"){
        val transaction = resultModel?.transaction?.receiveAmount
    }
    return PickupResponse().apply {
        ResponseCode = responseCode; ResponseMessage = responseMessage.toString();
        TransactionAmount = resultModel?.transaction?.receiveAmount.toString()
        TransactionReceiverFirstName = resultModel?.recipient?.name;
        TransactionReceiverLastName = resultModel?.recipient?.name;
        TransactionReference = resultModel?.transaction?.transRef;
        TransactionSenderFirstName = resultModel?.sender?.name;
        TransactionSenderLastName = resultModel?.sender?.name;
        TransactionStatus = resultModel?.transaction?.status;
        TransactionSenderCityAddress = resultModel?.sender?.address1;
        TransactionDestinationCountryCurrency= resultModel?.transaction?.receiveCurrency ?: "USD"
        TransactionCurrency = resultModel?.transaction?.sendCurrency ?: "USD";
        TransactionMtoCode = mtoCode;
        TransactionSenderNationality = resultModel?.sender?.country
        TransactionReceiverNationality = resultModel?.recipient?.country;
        TransactionSenderPhoneNumber = resultModel?.sender?.mobile
        TransactionReceiverPhoneNumber = resultModel?.recipient?.mobile;
        TransactionSenderIdNumber = resultModel?.sender?.idNumber
        TransactionSenderIdExpiryDate = resultModel?.sender?.idExpiry

    }
}


fun LookupResponse.toTransaction(mtoCode : String) : PickupResponse{
    val responseCode = if (CANTIDAD_REGISTROS == 0) "92" else "00"
    val responseMessage = if (CANTIDAD_REGISTROS == 0) "transaction not found" else "success"
    return PickupResponse().apply {
        ResponseCode = responseCode; ResponseMessage = responseMessage; TransactionAmount = LISTADO?.item?.VALOR_ENVIADO.toString()
        TransactionReceiverFirstName = LISTADO?.item?.BEN_PRIMER_NOMBRE; TransactionReceiverLastName = LISTADO?.item?.BEN_PRIMER_APELLIDO;
        TransactionReference = LISTADO?.item?.ID_OPERACION; TransactionSenderFirstName = LISTADO?.item?.REM_PRIMER_NOMBRE;
        TransactionSenderLastName = LISTADO?.item?.REM_PRIMER_APELLIDO; TransactionStatus = LISTADO?.item?.ESTADO_GIRO;
        TransactionSenderCityAddress = "${LISTADO?.item?.REM_CIUDAD} ${LISTADO?.item?.REM_DIRECCION}";
        TransactionDestinationCountryCurrency= LISTADO?.item?.MONEDA_PAGO; TransactionMtoCode = mtoCode
        TransactionCurrency = LISTADO?.item?.MONEDA_ORIGEN; TransactionSenderNationality = LISTADO?.item?.REM_PAIS
        TransactionId = LISTADO?.item?.ID_INTERNO; TransactionReceiverNationality = LISTADO?.item?.BEN_PAIS;
        TransactionReceiverPhoneNumber =  LISTADO?.item?.BEN_TELEFONO; TransactionPurposeCode = LISTADO?.item?.ID_INTERNO
    }
}





fun String.toDocument(): Document{
   val doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(InputSource(StringReader(this)))
    doc.documentElement.normalize()
    return doc
}

fun Node.toActualString(): String{
    val sw = StringWriter()
    val t = TransformerFactory.newInstance().newTransformer()
    t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes")
    t.transform(DOMSource(this), StreamResult(sw))
    return sw.toString()
}

fun SendWaveResponsePickUp.toPayResponse() : BaseResponse{
    return BaseResponse(responseCode, responseMessage)
}

fun FlutterWavePaymentResponse.toPayResponse() : BaseResponse{
    return BaseResponse(responseCode, responseDesc)
}

fun PayTransactionResponse.toPayResponse() : BaseResponse{
    val code = if(Code == "1") "00"  else Code
   return BaseResponse(code, Message!!)
}

fun PayTransactionErrorResponse.toPayResponse() : BaseResponse{
    val code = if(Code == "1") "00"  else Code
   return BaseResponse(code, Message!!.joinToString(","))
}

fun GetTransactionStatus.toPayResponse() : BaseResponse{
    val code = if(resultModel?.status == "OK") "00"  else resultModel?.status
    val mgsstatus = if(resultModel?.status == "OK") "success"  else resultModel?.error
    return BaseResponse(code, mgsstatus)
}

fun PayTransRequest.toCreateCollection() : CreateCollectionRequest{
    val branch = CreateCollectionRequest.Branch("35, Marina Lagos", "Lagos Island",
        this.transactionSoleId ?: "230", "NGA", "Marina Branch", "100221")
   return CreateCollectionRequest(branch, this.transactionReference, this.transactionReference)
}

fun GetTransExportByFolio.toXMLRequest(): String{
   return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.ie.smallworldfs.com/">
                <soapenv:Header/>
                <soapenv:Body>
                    <web:getTransactionExportByMtn>
                        <arg0>${this.folionumber}</arg0>
                        <arg4>api101575</arg4>
                        <arg5>ce01cd8d74f2755d395614dd3fdcdd3f9cb193a7</arg5>
                    </web:getTransactionExportByMtn>
                </soapenv:Body>
            </soapenv:Envelope>
        """.trimIndent()
}



fun String.toXMLRequest(username: String, password: String): String{
   return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.ie.smallworldfs.com/">
                <soapenv:Header/>
                <soapenv:Body>
                    <web:getTransactionExportByMtn>
                        <arg0>$this</arg0>
                        <arg4>$username</arg4>
                        <arg5>$password</arg5>
                    </web:getTransactionExportByMtn>
                </soapenv:Body>
            </soapenv:Envelope>
        """.trimIndent()
}

fun String.toIDTPSXMLRequest(config : HashMap<String, String>): String{
   return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:por="${config["baseurl"]!!}">
               <soapenv:Header/>
               <soapenv:Body>
                  <por:ConsultaGiro>
                     <registro>
                        <ID_INTEGRACION>${config["integrationid"]!!}</ID_INTEGRACION>
                        <USUARIO>${config["usercode"]!!}</USUARIO>
                        <ID_OPERACION>$this</ID_OPERACION>
                        <ID_PAGADOR>${config["payerscode"]!!}</ID_PAGADOR>
                        <CORRELATIVO_ID></CORRELATIVO_ID>
                        <MONTO_PAGAR></MONTO_PAGAR>
                        <AGENT_ID></AGENT_ID>
                     </registro>
                  </por:ConsultaGiro>
               </soapenv:Body>
            </soapenv:Envelope>
        """.trimIndent()
}



fun PayTransRequest.toReserveRequest(config : HashMap<String, String>): String{
   return """
       <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:por="${config["baseurl"]!!}">
          <soapenv:Header/>
          <soapenv:Body>
             <por:Reserva>
                <registro>
                   <ID_INTEGRACION>${config["integrationid"]!!}</ID_INTEGRACION>
                   <USUARIO>${config["usercode"]!!}</USUARIO>
                   <ID_INTERNO>${this.transactionPurposeCode}</ID_INTERNO>
                   <ID_OPERACION>${this.transactionReference}</ID_OPERACION>
                   <ID_PAGADOR>${config["payerscode"]!!}</ID_PAGADOR>
                   <CORRELATIVO_ID></CORRELATIVO_ID>
                   <VALOR_PAGAR>${this.transactionAmount!!}</VALOR_PAGAR>
                   <LOCAL_RESERVA>${this.transactionSoleId}</LOCAL_RESERVA>
                   <CAJA_RESERVA></CAJA_RESERVA>
                   <CAJERO_RESERVA></CAJERO_RESERVA>
                </registro>
             </por:Reserva>
          </soapenv:Body>
       </soapenv:Envelope>
        """.trimIndent()
}


fun PayTransRequest.toReleaseRequest(config : HashMap<String, String>, reservationId: String?): String{
   return """
       <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:por="${config["baseurl"]!!}">
          <soapenv:Header/>
          <soapenv:Body>
             <por:LiberaRemesa>
                <registro>
                   <ID_INTEGRACION>${config["integrationid"]!!}</ID_INTEGRACION>
                   <USUARIO>${config["usercode"]!!}</USUARIO>
                   <ID_OPERACION>${this.transactionReference}</ID_OPERACION>
                   <ID_PAGADOR>${config["payerscode"]!!}</ID_PAGADOR>
                   <ID_INTERNO>${this.transactionPurposeCode}</ID_INTERNO>
                   <CORRELATIVO_ID></CORRELATIVO_ID>
                   <ID_RESERVA>$reservationId</ID_RESERVA>
                   <VALOR_PAGAR>${this.transactionAmount!!.toDoubleOrNull()!!}</VALOR_PAGAR>
                   <LOCAL_RESERVA>${this.transactionSoleId}</LOCAL_RESERVA>
                   <CAJA_RESERVA></CAJA_RESERVA>
                   <CAJERO_RESERVA></CAJERO_RESERVA>
                </registro>
             </por:LiberaRemesa>
         </soapenv:Body>
       </soapenv:Envelope>
        """.trimIndent()
}


fun PaymentResponse.toBaseResponse() : BaseResponse{
    return when (CODIGO_MENSAJE == 1800){
        true -> BaseResponse("00", "success")
        else -> BaseResponse("$CODIGO_MENSAJE", "unable to pay transaction")
    }
}



fun ReleaseResponse.toBaseResponse() : BaseResponse{
    return when (CODIGO_MENSAJE == 1700){
        true -> BaseResponse("00", "success")
        else -> BaseResponse("$CODIGO_MENSAJE", "unable to release request")
    }
}


fun PayTransRequest.toPayment(config : HashMap<String, String>, reservationId : String?): String{
   return """
       <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:por="${config["baseurl"]!!}">
           <soapenv:Header/>
           <soapenv:Body>
               <por:AutorizaPago>
                   <registro>
                       <ID_INTEGRACION>${config["integrationid"]!!}</ID_INTEGRACION>
                       <USUARIO>${config["usercode"]!!}</USUARIO>
                       <ID_PAGADOR>${config["payerscode"]!!}</ID_PAGADOR>
                       <ID_INTERNO>${this.transactionPurposeCode}</ID_INTERNO>
                       <ID_RESERVA>$reservationId</ID_RESERVA>
                       <ID_OPERACION>${this.transactionReference}</ID_OPERACION>
                       <CORRELATIVO_ID></CORRELATIVO_ID>
                       <MONEDA_PAGO>${this.transactionDestinationCountryCurrency}</MONEDA_PAGO>
                       <VALOR_PAGAR>${this.transactionAmount}</VALOR_PAGAR>
                       <BEN_PRIMER_NOMBRE>${this.transactionReceiverFirstName}</BEN_PRIMER_NOMBRE>
                       <BEN_SEGUNDO_NOMBRE></BEN_SEGUNDO_NOMBRE>
                       <BEN_PRIMER_APELLIDO>${this.transactionReceiverLastName}</BEN_PRIMER_APELLIDO>
                       <BEN_SEGUNDO_APELLIDO></BEN_SEGUNDO_APELLIDO>
                       <BEN_TELEFONO>${this.transactionReceiverPhoneNumber}</BEN_TELEFONO>
                       <BEN_PAIS>${this.transactionReceiverNationality}</BEN_PAIS>
                       <CAJA_RESERVA></CAJA_RESERVA>
                       <GENERO></GENERO>
                       <NACIONALIDAD></NACIONALIDAD>
                       <FECHA_NACIMIENTO></FECHA_NACIMIENTO>
                       <PAIS_NACIMIENTO></PAIS_NACIMIENTO>
                       <ESTADO_NACIMIENTO></ESTADO_NACIMIENTO>
                       <LUGAR_NACIMIENTO></LUGAR_NACIMIENTO>
                       <DIRECCION>NINGUNA</DIRECCION>
                       <OCUPACION></OCUPACION>
                       <COMENTARIO>NINGUNO</COMENTARIO>
                       <LOCAL_RESERVA>${this.transactionSoleId}</LOCAL_RESERVA>
                       <PAIS_RESIDENCIA></PAIS_RESIDENCIA>
                       <DEPARTAMENTO></DEPARTAMENTO>
                       <MUNICIPIO></MUNICIPIO>
                       <AGENT_ID></AGENT_ID>
                       <MOTIVO_RECEPCION></MOTIVO_RECEPCION>
                       <ACTIVIDAD_ECONOMICA></ACTIVIDAD_ECONOMICA>
                       <INGRESOS_MENSUALES></INGRESOS_MENSUALES>
                       <EGRESOS_MENSUALES></EGRESOS_MENSUALES>
                       <CANTIDAD_REMESAS></CANTIDAD_REMESAS>
                       <RELACION_REMITENTE>ESPOSO/A</RELACION_REMITENTE>
                       <TIPO_REMESA>F</TIPO_REMESA>
                       <VERIFICACION_TERCERO>SI</VERIFICACION_TERCERO>
                       <VERIFICACION_AGENTE>SI</VERIFICACION_AGENTE>
                   </registro>
               </por:AutorizaPago>
           </soapenv:Body>
       </soapenv:Envelope>

        """.trimIndent()
}







fun String.toMTNByFolio(username: String, password : String): String{
    return """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.ie.smallworldfs.com/">
            <soapenv:Header/> <soapenv:Body>
                <web:getMtnByFolio>
                    <arg0>$this</arg0>
                    <arg1>$username</arg1> 
                    <arg2>$password</arg2>
                </web:getMtnByFolio> 
            </soapenv:Body>
        </soapenv:Envelope>
    """.trimIndent()
}

fun String.toPayoutAnywhere(locationCode: String, note : String, payerCode : String, username : String, password : String) : String{
    return """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.ie.smallworldfs.com/">
            <soapenv:Body>
                <web:payoutPickupAnywhereTransaction>
                    <arg0>$this</arg0>
                    <arg1>$note</arg1>
                    <arg3>${LocalDateTime.now()}a</arg3>
                    <arg4>$payerCode</arg4>
                    <arg5>$locationCode</arg5>
                    <arg7>$username</arg7>
                    <arg8>$password</arg8>
                </web:payoutPickupAnywhereTransaction>
            </soapenv:Body>
        </soapenv:Envelope>
    """.trimIndent()
}

fun JSONObject.extractRequest(tag: String) : JSONObject{
   return this.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("ns2:$tag")
}


fun JSONObject.extractIDTPSResponse(tag: String) : JSONObject{
   return this.getJSONObject("SOAP-ENV:Envelope").getJSONObject("SOAP-ENV:Body").getJSONObject("ns1:$tag")
}


fun JSONObject.extractFailureRequest() : String{
   return this.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").getJSONObject("soapenv:Fault").getString("faultstring")
}

fun JSONObject.extractIdtpsFailureRequest() : String{
   return this.getJSONObject("SOAP-ENV:Envelope").getJSONObject("SOAP-ENV:Body").getJSONObject("SOAP-ENV:Fault").getString("faultstring")
}

fun String.toXMLError(type : String) : String {
    val response = Gson().fromJson(this, BaseResponse::class.java)
    val escapedResponse = StringEscapeUtils.unescapeJava(response.ResponseMessage!!)
    return when(type){
        "smallworld" -> XML.toJSONObject(escapedResponse).extractFailureRequest()
        else ->  XML.toJSONObject(escapedResponse).extractIdtpsFailureRequest()
    }
}











