package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductResultContract
import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductResultPresenter
import com.mercadolibre.searchapplication.presentation.fragments.search.SearchSuggestionContract
import com.mercadolibre.searchapplication.presentation.fragments.search.SearchSuggestionPresenter
import org.koin.dsl.module

val getProductPresenter = module {
    single<ProductResultContract.Presenter> { ProductResultPresenter(get()) }
}

val getSuggestionPresenter = module {
    single<SearchSuggestionContract.Presenter> { SearchSuggestionPresenter(get()) }
}

