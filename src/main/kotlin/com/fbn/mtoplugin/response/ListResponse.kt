package com.fbn.mtoplugin.response


data class ListResponse(
        var ResponseCode : String?,
        var ResponseMessage: String?,
        var data: List<*>
)