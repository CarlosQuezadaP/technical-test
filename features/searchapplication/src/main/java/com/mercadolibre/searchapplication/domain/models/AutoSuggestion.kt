package com.mercadolibre.searchapplication.domain.models


data class AutoSuggestion(
    val query: String,
    val suggestions: List<String>
)
