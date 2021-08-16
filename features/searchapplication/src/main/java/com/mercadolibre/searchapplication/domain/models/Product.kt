package com.mercadolibre.searchapplication.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val price: Long,
    val originalPrice: Long?,
    val discount: Long?,
    val image: String,
    val installments: Installments?,
    val isFreeShipping: Boolean,
    val isWithoutInterest: Boolean
) : Parcelable


