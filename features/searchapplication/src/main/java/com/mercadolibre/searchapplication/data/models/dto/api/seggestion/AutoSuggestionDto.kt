package com.mercadolibre.searchapplication.data.models.dto.api.seggestion

import com.google.gson.annotations.SerializedName


data class AutoSuggestionDto(
    @SerializedName("q")
    val query: String
)
