package com.mercadolibre.searchapplication.domain.models

import android.os.Parcelable
import com.mercadolibre.searchapplication.extensions.formatPrice
import kotlinx.parcelize.Parcelize

@Parcelize
data class Installments(val quantity: Int, val amount: Double) : Parcelable {
    override fun toString() = "${quantity}x ${amount.formatPrice()}"
}
