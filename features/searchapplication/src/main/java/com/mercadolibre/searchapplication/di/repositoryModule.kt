package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.domain.repositories.IProductsRepository
import com.mercadolibre.searchapplication.repository.ProductRepository
import org.koin.dsl.module

val productRepositoryModule = module {
    single<IProductsRepository> { ProductRepository(get()) }
}



