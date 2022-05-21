package com.fbn.mtoplugin.request.idtps

import javax.validation.constraints.NotEmpty

data class IDTPSPickupRequest(@NotEmpty(message = "transactionnumber is required") var transactionnumber : String?)