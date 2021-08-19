package com.mercadolibre.searchapplication.data.api

import com.mercadolibre.searchapplication.data.models.dto.api.detail.ProductDetailDto
import com.mercadolibre.searchapplication.data.models.dto.api.resultProducts.ProductResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiDetail {

    @GET("items/{id}/description")
    suspend fun getProductDescription(@Path("id") productId: String): ProductDetailDto

}
