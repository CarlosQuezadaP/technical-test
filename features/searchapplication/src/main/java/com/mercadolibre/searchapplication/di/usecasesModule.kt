package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.domain.usecases.GetProductDetailUseCase
import com.mercadolibre.searchapplication.domain.usecases.GetProductsUseCase
import com.mercadolibre.searchapplication.domain.usecases.GetSuggestionsUseCase
import com.mercadolibre.searchapplication.repository.ProductDetailRepository
import org.koin.dsl.module

val productUseCaseModule = module {
    single { GetProductsUseCase(get()) }
}

val suggestionUseCaseModule = module {
    single { GetSuggestionsUseCase(get()) }
}

val productDetailUseCaseModule = module {
    single { GetProductDetailUseCase(get()) }
}

