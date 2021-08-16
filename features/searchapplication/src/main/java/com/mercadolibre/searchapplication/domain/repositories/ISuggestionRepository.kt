package com.mercadolibre.searchapplication.domain.repositories

import com.mercadolibre.core.resultWrapper.ResultWrapper
import com.mercadolibre.searchapplication.domain.models.AutoSuggestion
import kotlinx.coroutines.flow.Flow

interface ISuggestionRepository {
    suspend fun getSuggestionByQuery(query:String): Flow<ResultWrapper<AutoSuggestion>>
}
