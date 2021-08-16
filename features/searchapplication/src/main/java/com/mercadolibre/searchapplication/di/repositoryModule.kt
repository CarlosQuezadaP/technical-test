package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.domain.repositories.IProductsRepository
import com.mercadolibre.searchapplication.domain.repositories.ISuggestionRepository
import com.mercadolibre.searchapplication.repository.ProductRepository
import com.mercadolibre.searchapplication.repository.SuggestionRepository
import org.koin.dsl.module

val productRepositoryModule = module {
    single<IProductsRepository> { ProductRepository(get()) }
}

val suggestionRepositoryModule = module {
    single<ISuggestionRepository> { SuggestionRepository(get()) }
}
