package com.online.store.application.dto.request

import com.online.store.application.enums.Category
import jakarta.validation.constraints.Size

data class AddProductsRequest(
    @field:Size(message = "Length should be between 1 and 10", min = 1, max = 30)
    val productName: String,
    @field:Size(message = "Length should be between 1 and 10", min = 1, max = 100)
    val description: String,
    val category: Category
)
