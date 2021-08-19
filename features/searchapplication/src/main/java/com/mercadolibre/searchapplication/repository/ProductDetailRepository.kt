package com.mercadolibre.searchapplication.repository

import arrow.core.Either
import com.mercadolibre.searchapplication.data.api.ApiDetail
import com.mercadolibre.searchapplication.domain.repositories.IProductDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductDetailRepository(private val apiDetail: ApiDetail) : IProductDetailRepository {
    override fun getProductDetail(productId: String): Flow<Either<Exception, String>> {
        return flow {
            emit(
                try {
                    Either.right(apiDetail.getProductDescription(productId).description)
                } catch (exception: Exception) {
                    Either.left(
                        exception
                    )
                }
            )
        }
    }


}