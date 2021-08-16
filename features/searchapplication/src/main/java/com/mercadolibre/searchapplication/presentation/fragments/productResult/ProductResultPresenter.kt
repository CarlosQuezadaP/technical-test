package com.mercadolibre.searchapplication.presentation.fragments.productResult

import com.mercadolibre.searchapplication.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductResultPresenter(
    private val getProductsUseCase: GetProductsUseCase
) : ProductResultContract.Presenter {

    override fun getProducts(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val products = getProductsUseCase.invoke(query).flow
            products
                .catch {
                    it.localizedMessage
                }
                .collect {
                    view.showProducts(it)
                }
        }
    }

    override lateinit var view: ProductResultContract.View

}
