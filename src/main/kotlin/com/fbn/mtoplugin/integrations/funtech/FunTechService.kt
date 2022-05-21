package com.fbn.mtoplugin.integrations.funtech

import com.fbn.mtoplugin.util.ApiCaller
import com.fbn.mtoplugin.util.ConfigUtil
import org.springframework.stereotype.Service

@Service
class FunTechService(private val apiCaller: ApiCaller,
                     private val configUtil: ConfigUtil) {
    private val token = hashMapOf("firsthead" to "citymanjoe", "firstheadkey" to "citymanjoe")
}