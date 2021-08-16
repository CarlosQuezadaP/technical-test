package com.mercadolibre.searchapplication.data.api

import com.mercadolibre.searchapplication.data.models.dto.api.seggestion.AutoSuggestionResults
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSuggestion {
    @GET("sites/MCO/autosuggest")
    suspend fun getAutoSuggestions(@Query("q") query: String): AutoSuggestionResults
}
