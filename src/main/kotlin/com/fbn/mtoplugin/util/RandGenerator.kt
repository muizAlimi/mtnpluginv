package com.fbn.mtoplugin.util

import org.springframework.stereotype.Service


@Service
class RandGenerator {
    fun getRandNumeric(len: Int): String? {
        val sb = StringBuffer(len)
        for (i in 0 until len) {
            val ndx = (Math.random() * "1234567890".length).toInt()
            sb.append("1234567890"[ndx])
        }
        return sb.toString()
    }
}
