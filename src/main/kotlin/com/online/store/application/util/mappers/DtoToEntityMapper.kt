package com.online.store.application.util.mappers

import com.online.store.application.dto.request.AddProductsRequest
import com.online.store.application.dto.response.FetchProducts
import com.online.store.application.entity.ProductInventory
import com.online.store.application.entity.Products
import com.online.store.application.util.random.RandomUtil

class DtoToEntityMapper {
    companion object {
        fun mapDtoToEntity(addProductsRequest: AddProductsRequest): Products {
            return Products(
                productId = RandomUtil.generateProductId(),
                productName = addProductsRequest.productName,
                description = addProductsRequest.description,
                category = addProductsRequest.category,
                inventory = ProductInventory(
                    stockQty = addProductsRequest.stockQty
                )
            )
        }

        fun mapEntityToDto(products: Products): FetchProducts {
            println("products map")
            return FetchProducts(
                productName = products.productName,
                description = products.description,
                category = products.category,
                qty = products.inventory.stockQty
            )
        }
    }
}