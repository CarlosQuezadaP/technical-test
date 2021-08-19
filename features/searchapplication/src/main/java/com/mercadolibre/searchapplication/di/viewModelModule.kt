package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.presentation.fragments.detail.SearchViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { SearchViewModel(get()) }
}
