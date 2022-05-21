package com.fbn.mtoplugin.response.idtps

data class LookupResponse(
    var CANTIDAD_REGISTROS: Int?,
    var CODIGO_MENSAJE: String?,
    var ID_INTEGRACION: String?,
    var LISTADO: LISTADO?,
    var TEXTO_MENSAJE: String?,
    var USUARIO: Int?
)

data class LISTADO(
    var item: Item?
)

data class Item(
    var BEN_PAIS: String?,
    var BEN_PRIMER_APELLIDO: String?,
    var BEN_PRIMER_NOMBRE: String?,
    var BEN_SEGUNDO_APELLIDO: String?,
    var BEN_SEGUNDO_NOMBRE: String?,
    var BEN_TELEFONO: String?,
    var CONSULTA_ONLINE: String?,
    var CORRELATIVO_ID: Int?,
    var ESTADO_GIRO: String?,
    var FEE_REM: String?,
    var ID_INTEGRACION: String?,
    var ID_INTERNO: String?,
    var ID_OPERACION: String?,
    var MENSAJE_DOS: Any?,
    var MENSAJE_UNO: String?,
    var MONEDA_ORIGEN: String?,
    var MONEDA_PAGO: String?,
    var OBSERVACIONES: String?,
    var REMESADOR: String?,
    var REM_CIUDAD: String?,
    var REM_DIRECCION: String?,
    var REM_ESTADO: String?,
    var REM_PAIS: String?,
    var REM_PRIMER_APELLIDO: String?,
    var REM_PRIMER_NOMBRE: String?,
    var REM_SEGUNDO_APELLIDO: String?,
    var REM_SEGUNDO_NOMBRE: String?,
    var TASA_CAMBIO: String?,
    var VALOR_ENVIADO: Double?,
    var VALOR_PAGAR: Double?
)