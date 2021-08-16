package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.presentation.fragments.search.SearchViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { SearchViewModel(get()) }
}
