package com.fbn.mtoplugin.util

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest


@Component
class WebUtil(private val request: HttpServletRequest) {


    fun clientIp(): String? {
        return request.getHeader("X-FORWARDED-FOR") ?: request.remoteAddr
    }

    fun deviceName(): String? {
        return request.getHeader("User-Agent") ?: "Unknown"
    }


}
