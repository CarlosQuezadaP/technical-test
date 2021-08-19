package com.mercadolibre.searchapplication.data.models.dto.api.detail

import com.google.gson.annotations.SerializedName

data class ProductDetailDto(
    @SerializedName("plain_text")
    val description: String
)