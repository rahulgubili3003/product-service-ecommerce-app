package com.online.store.application.dto.request

import jakarta.validation.constraints.NotEmpty

data class GetInventoryDetails(
    @field:NotEmpty(message = "Products List must not be empty")
    val productIdsList: List<String>
)
