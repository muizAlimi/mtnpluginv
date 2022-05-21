package com.fbn.mtoplugin.response.idtps

data class PaymentResponse(
    var CODIGO_MENSAJE: Int?,
    var FECHA_PAGO: String?,
    var HORA_PAGO: String?,
    var ID_INTEGRACION: String?,
    var ID_INTERNO: String?,
    var ID_PAGO: Any?,
    var RESERVA_PAGO1: Any?,
    var RESERVA_PAGO2: Any?,
    var RESERVA_PAGO3: Any?,
    var RESERVA_PAGO4: Any?,
    var TEXTO_MENSAJE: String?,
    var USUARIO: Int?
)