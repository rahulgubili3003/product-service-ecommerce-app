package com.online.store.application.util.mappers

import com.online.store.application.dto.request.AddProductsRequest
import com.online.store.application.dto.response.FetchProducts
import com.online.store.application.entity.ProductInventory
import com.online.store.application.entity.Products

class DtoToEntityMapper {
    companion object {
        fun mapDtoToEntity(addProductsRequest: AddProductsRequest): Products {
            return Products(
                productName = addProductsRequest.productName,
                description = addProductsRequest.description,
                category = addProductsRequest.category,
                inventory = ProductInventory(
                    itemsNumber = addProductsRequest.stockQty
                )
            )
        }

        fun mapEntityToDto(products: Products): FetchProducts {
            return FetchProducts(
                productName = products.productName,
                description = products.description,
                category = products.category,
                qty = products.inventory.itemsNumber
            )
        }
    }
}