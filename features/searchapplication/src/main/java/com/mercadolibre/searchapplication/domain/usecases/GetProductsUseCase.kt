package com.mercadolibre.searchapplication.domain.usecases

import androidx.paging.Pager
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.domain.repositories.IProductsRepository
import com.mercadolibre.searchapplication.repository.ProductRepository

class GetProductsUseCase(private val productRepository: IProductsRepository) {

    operator fun invoke(query: String): Pager<Int, Product> {
        return productRepository.getProducts(query)
    }
}
