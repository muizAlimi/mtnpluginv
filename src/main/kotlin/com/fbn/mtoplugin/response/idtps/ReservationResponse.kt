package com.fbn.mtoplugin.response.idtps

data class ReservationResponse(
    var CODIGO_MENSAJE: Int?,
    var FECHA_VENCE_RESERVA: String?,
    var HORA_VENCE_RESERVA: String?,
    var ID_INTEGRACION: String?,
    var ID_INTERNO: Any?,
    var ID_RESERVA: String?,
    var TEXTO_MENSAJE: String?,
    var USUARIO: Int?
)