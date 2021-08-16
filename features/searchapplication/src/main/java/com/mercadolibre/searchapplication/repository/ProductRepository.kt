package com.mercadolibre.searchapplication.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mercadolibre.searchapplication.data.api.ApiProducts
import com.mercadolibre.searchapplication.data.paging.ProductPaging
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.domain.repositories.IProductsRepository

class ProductRepository(private val apiProducts: ApiProducts) : IProductsRepository {

    override fun getProducts(query: String): Pager<Int, Product> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { ProductPaging(apiProducts, query) }
        )
    }
}
