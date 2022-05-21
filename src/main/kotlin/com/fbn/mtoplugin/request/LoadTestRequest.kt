package com.fbn.mtoplugin.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class LoadTestRequest(
    @get:NotEmpty(message = "imtoCode is required")
    var imtoCode: String?,
    @get:NotNull(message = "numberOfRequest is required")
    var numberOfRequest: Int?
)