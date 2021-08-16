package com.condor.data.di

import com.mercadolibre.searchapplication.data.api.ApiProducts
import com.mercadolibre.searchapplication.data.api.ApiSuggestion
import com.mercadolibre.searchapplication.data.network.BASE_URL
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val NETWORK_AVAILABLE_AGE = 10

val networkModule = module {
    val connectTimeout: Long = 10
    val readTimeout: Long = 10

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)


        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request()
            val originalHttpUrl = request.url

            val url = originalHttpUrl.newBuilder()
                .build()

            chain.proceed(
                request.newBuilder()
                    .url(url)
                    .removeHeader("Pragma")
                    .addHeader("Content-type", "application/json")
                    .addHeader("Cache-Control", "public, max-age=$NETWORK_AVAILABLE_AGE")
                    .build()
            )
        }

        okHttpClientBuilder.build()
        return okHttpClientBuilder.build()
    }

    fun provideBuild(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient())
            .build()
    }

    single<ApiProducts> {
        provideBuild()
            .create(ApiProducts::class.java)
    }

    single<ApiSuggestion> {
        provideBuild()
            .create(ApiSuggestion::class.java)
    }

}
