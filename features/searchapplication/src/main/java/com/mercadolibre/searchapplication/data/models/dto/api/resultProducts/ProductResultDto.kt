package com.mercadolibre.searchapplication.data.models.dto.api.resultProducts

import com.google.gson.annotations.SerializedName

data class ProductResultDto(
    @SerializedName("paging")
    val pagingDto: PagingDto,
    @SerializedName("results")
    val results: List<ProductDto>
)
