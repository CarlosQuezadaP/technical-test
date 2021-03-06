package com.mercadolibre.searchapplication.domain.usecases

import arrow.core.Either
import com.mercadolibre.searchapplication.domain.repositories.IProductDetailRepository
import com.mercadolibre.searchapplication.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow

class GetProductDetailUseCase(private val productDetailRepository: IProductDetailRepository) {

    operator fun invoke(productId: String): Flow<Either<Exception, String>> {
        return productDetailRepository.getProductDetail(productId)
    }
}