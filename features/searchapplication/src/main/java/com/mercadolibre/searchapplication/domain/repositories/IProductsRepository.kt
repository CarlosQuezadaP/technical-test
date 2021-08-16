package com.mercadolibre.searchapplication.domain.repositories

import androidx.paging.Pager
import com.mercadolibre.searchapplication.domain.models.Product

interface IProductsRepository {

    fun getProducts(query: String): Pager<Int, Product>
}
