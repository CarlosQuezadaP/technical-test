package com.mercadolibre.searchapplication.data.models.dto.api

import com.google.gson.annotations.SerializedName
import com.mercadolibre.searchapplication.domain.models.Installments

data class installmentsDto(
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("amount")
    val amount: Double
) {

    fun toInstallments() = Installments(quantity, amount)
}
