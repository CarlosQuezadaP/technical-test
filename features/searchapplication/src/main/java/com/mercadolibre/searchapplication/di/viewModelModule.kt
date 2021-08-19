package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.presentation.fragments.detail.ProductDetailViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { ProductDetailViewModel(get()) }
}
