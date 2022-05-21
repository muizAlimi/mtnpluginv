package com.fbn.mtoplugin.response.idtps

data class ReleaseResponse(
    var CODIGO_MENSAJE: Int?,
    var FECHA_LIBERACION: String?,
    var HORA_LIBERACION: String?,
    var ID_INTEGRACION: String?,
    var ID_INTERNO: String?,
    var ID_LIBERACION: Int?,
    var ID_PAGADOR: String?,
    var TEXTO_MENSAJE: String?,
    var USUARIO: Int?
)