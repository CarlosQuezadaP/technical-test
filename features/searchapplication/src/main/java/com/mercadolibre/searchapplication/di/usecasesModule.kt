package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.domain.usecases.GetProductsUseCase
import com.mercadolibre.searchapplication.domain.usecases.GetSuggestionsUseCase
import org.koin.dsl.module

val productUseCaseModule = module {
    single { GetProductsUseCase(get()) }
}

val suggestionUseCaseModule = module {
    single { GetSuggestionsUseCase(get()) }
}



