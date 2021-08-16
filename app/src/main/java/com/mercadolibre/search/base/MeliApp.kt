package com.mercadolibre.search.base

import android.app.Application
import com.condor.data.di.networkModule
import com.mercadolibre.searchapplication.di.getProductPresenter
import com.mercadolibre.searchapplication.di.productRepositoryModule
import com.mercadolibre.searchapplication.di.productUseCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeliApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MeliApp)
            modules(
                networkModule,
                productRepositoryModule,
                productUseCaseModule,
                getProductPresenter
            )
        }
    }
}