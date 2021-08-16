package com.mercadolibre.searchapplication.data.api

import com.mercadolibre.searchapplication.data.models.dto.api.ProductResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiProducts {

    @GET("sites/MCO/search")
    suspend fun getProducts(
        @Query("q") query: String,
        @Query("offset") offset: Int
    ): ProductResultDto
}
