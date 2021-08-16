package com.mercadolibre.searchapplication.data.models.dto.api

import com.google.gson.annotations.SerializedName
import com.mercadolibre.searchapplication.domain.models.Product

data class ProductDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val name: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("original_price")
    val originalPrice: Long?,
    @SerializedName("thumbnail")
    val image: String,
    @SerializedName("installments")
    val installments: installmentsDto?,
    @SerializedName("shipping")
    val shippingDto: ShippingDto,
    @SerializedName("differential_pricing")
    val differentialPricingDto: DifferentialPricingDto?
) {

    fun toProduct() = Product(
        id,
        name,
        price,
        originalPrice,
        applyDiscount(),
        image,
        installments?.toInstallments(),
        shippingDto.freeShipping,
        differentialPricingDto != null
    )

    private fun applyDiscount(): Long? {
        return originalPrice?.let {
            val difference = originalPrice - price
            if (difference != 0L) {
                return (difference * 100) / originalPrice
            }
            return null
        }
    }

}
