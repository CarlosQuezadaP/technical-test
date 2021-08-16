package com.mercadolibre.searchapplication.data.models.dto.api.resultProducts

import com.google.gson.annotations.SerializedName


data class ShippingDto(
    @SerializedName("free_shipping")
    val freeShipping: Boolean
)
