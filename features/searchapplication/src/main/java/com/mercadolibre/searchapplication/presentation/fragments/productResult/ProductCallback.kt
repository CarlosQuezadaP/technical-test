package com.mercadolibre.searchapplication.presentation.fragments.productResult

import com.mercadolibre.searchapplication.domain.models.Product

interface ProductCallback {
    fun onProductClick(product:Product)
}
