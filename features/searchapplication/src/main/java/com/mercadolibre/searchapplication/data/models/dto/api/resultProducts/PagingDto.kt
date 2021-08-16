package com.mercadolibre.searchapplication.data.models.dto.api.resultProducts

import com.google.gson.annotations.SerializedName

data class PagingDto(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total")
    val total: Int
)
