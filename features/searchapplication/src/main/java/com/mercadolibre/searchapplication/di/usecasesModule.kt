package com.mercadolibre.searchapplication.di

import com.mercadolibre.searchapplication.domain.usecases.GetProductsUseCase
import org.koin.dsl.module

val productUseCaseModule = module {
    single { GetProductsUseCase(get()) }
}
