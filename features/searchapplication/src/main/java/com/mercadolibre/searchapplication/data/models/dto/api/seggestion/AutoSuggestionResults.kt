package com.mercadolibre.searchapplication.data.models.dto.api.seggestion

import com.google.gson.annotations.SerializedName
import com.mercadolibre.searchapplication.domain.models.AutoSuggestion

data class AutoSuggestionResults(
    @SerializedName("q")
    val query: String,
    @SerializedName("suggested_queries")
    val autoSuggestions: List<AutoSuggestionDto>
) {

    fun toAutosuggestion() = AutoSuggestion(
        query,
        autoSuggestions.map { it.query }
    )
}
