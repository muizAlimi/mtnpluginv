package com.fbn.mtoplugin.controller

import com.fbn.mtoplugin.integrations.funtech.FunTechService
import com.fbn.mtoplugin.request.GetTransExportByFolio
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/funtech")
class FunTechController(private val funTechService: FunTechService) {

    @PostMapping("/get-transaction")
    fun getTransactionByFolio(@Valid @RequestBody getMtn: GetTransExportByFolio) : ResponseEntity<*> {
        var response = 0
        return ResponseEntity(response, HttpStatus.OK)
    }
}