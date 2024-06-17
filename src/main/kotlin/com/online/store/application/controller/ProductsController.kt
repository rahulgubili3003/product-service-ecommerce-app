package com.online.store.application.controller

import com.online.store.application.dto.request.AddProductsRequest
import com.online.store.application.dto.request.FetchInventory
import com.online.store.application.dto.response.OkResponse
import com.online.store.application.service.ProductsService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ProductsController(private val productsService: ProductsService) {

    @PostMapping("/addProducts")
    fun addProducts(@Valid @RequestBody addProductsRequest: AddProductsRequest): ResponseEntity<OkResponse> {
        val product = productsService.addProducts(addProductsRequest)
        return ResponseEntity.ok(OkResponse(data =  product.id))
    }

    @GetMapping("/getInventory/{productId}")
    fun getInventory(@Valid @PathVariable productId: Long): ResponseEntity<OkResponse> {
        val items = productsService.fetchInventory(productId)
        return ResponseEntity.ok(OkResponse(data = items))
    }
}