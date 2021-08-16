package com.mercadolibre.searchapplication.presentation.fragments.productResult

import androidx.paging.PagingData
import com.mercadolibre.searchapplication.base.BasePresenter
import com.mercadolibre.searchapplication.base.BaseView
import com.mercadolibre.searchapplication.domain.models.Product

interface ProductResultContract {

    interface View : BaseView<Presenter> {

        fun showProducts(products: PagingData<Product>)

        fun showLoading()

        fun hideLoading()
    }

    interface Presenter : BasePresenter<View> {

        fun getProducts(query: String)
    }

}
