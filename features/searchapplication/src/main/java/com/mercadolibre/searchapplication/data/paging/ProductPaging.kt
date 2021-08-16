package com.mercadolibre.searchapplication.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mercadolibre.searchapplication.data.api.ApiProducts
import com.mercadolibre.searchapplication.domain.models.Product
import java.io.IOException
import retrofit2.HttpException

class ProductPaging(private val apiProducts: ApiProducts, private val query: String) :
    PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val nextProducts = params.key ?: 0

        return try {
            val response = apiProducts.getProducts(query, nextProducts)
            LoadResult.Page(
                data = response.results.map { it.toProduct() },
                prevKey = null,
                nextKey = if (response.pagingDto.total == 0) {
                    null
                } else {
                    response.pagingDto.offset + 50
                }
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        } catch (unknownException: Exception) {
            return LoadResult.Error(unknownException)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition
    }
}

