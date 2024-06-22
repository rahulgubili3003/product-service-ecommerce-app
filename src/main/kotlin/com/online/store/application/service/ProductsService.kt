package com.online.store.application.service

import com.online.store.application.dto.request.AddProductsRequest
import com.online.store.application.dto.response.FetchProducts
import com.online.store.application.dto.response.InventoryDetailsResponse
import com.online.store.application.entity.Products
import com.online.store.application.repository.ProductsRepository
import com.online.store.application.util.mappers.DtoToEntityMapper
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class ProductsService(private val productsRepository: ProductsRepository) {

    fun addProducts(@Valid addProductsRequest: AddProductsRequest): Products {
        val product = DtoToEntityMapper.mapDtoToEntity(addProductsRequest)
        return productsRepository.save(product)
    }

    fun fetchInventory(productId: Long): Int {
        val productsOptional = productsRepository.findById(productId)
        return productsOptional.map { product ->
            // If present, return the number of items in the inventory
            product.inventory.stockQty
        }.orElseThrow { RuntimeException("Product Not Found") }
    }

    fun getAllInventory(): List<FetchProducts> {
        val products = productsRepository.findAll()
        return products.map { product ->
            DtoToEntityMapper.mapEntityToDto(product)
        }
    }

    fun getInventoryList(productsList: List<String>): List<InventoryDetailsResponse> {
        val productsList = productsRepository.findAllByProductId(productsList)
        val filtered = productsList.stream().map { it.inventory.stockQty > 0 }.toList()
    }
}