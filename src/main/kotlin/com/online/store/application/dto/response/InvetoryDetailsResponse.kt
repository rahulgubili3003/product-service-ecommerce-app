package com.online.store.application.dto.response

import com.online.store.application.dto.request.GetInventoryDetails

data class InventoryDetailsResponse(
    val productId: String,
    val isInStock: Boolean
)
