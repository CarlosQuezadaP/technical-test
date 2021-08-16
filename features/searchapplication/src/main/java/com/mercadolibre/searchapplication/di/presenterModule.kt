package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductResultContract
import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductResultPresenter
import org.koin.dsl.module

val getProductPresenter = module {
    single<ProductResultContract.Presenter> { ProductResultPresenter(get()) }
}


