package com.online.store.application.repository

import com.online.store.application.entity.ProductInventory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsInventoryRepository: JpaRepository<ProductInventory, Long> {
}