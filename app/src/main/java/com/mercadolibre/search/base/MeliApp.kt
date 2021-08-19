package com.mercadolibre.search.base

import android.app.Application
import com.condor.data.di.networkModule
import com.mercadolibre.searchapplication.di.*
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
                suggestionRepositoryModule,
                productDetailRepositoryModule,

                productUseCaseModule,
                suggestionUseCaseModule,
                productDetailUseCaseModule,

                getProductPresenter,
                getSuggestionPresenter,
                viewModelModule,
            )
        }
    }
}
