package com.online.store.application.repository

import com.online.store.application.entity.Products
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository: JpaRepository<Products, Long> {

    fun findByProductIdIn(productsList: List<String>): List<Products>
}