package com.online.store.application.dto.response

import com.online.store.application.enums.Category

data class FetchProducts(
    val productName: String,
    val description: String,
    val qty: Int,
    val category: Category
)
