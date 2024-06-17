package com.online.store.application.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.online.store.application.enums.Category
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AddProductsRequest(
    @field:Size(message = "Length should be between 1 and 10", min = 1, max = 30)
    val productName: String,
    @field:Size(message = "Length should be between 1 and 10", min = 1, max = 100)
    val description: String,
    val category: Category,
    @field:PositiveOrZero(message = "Stock quantity must be 0 or a positive integer.")
    val stockQty: Int
)
