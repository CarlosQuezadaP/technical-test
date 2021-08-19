package com.mercadolibre.searchapplication.domain.repositories

import arrow.core.Either
import kotlinx.coroutines.flow.Flow

interface IProductDetailRepository {

    fun getProductDetail(productId:String): Flow<Either<Exception, String>>
}