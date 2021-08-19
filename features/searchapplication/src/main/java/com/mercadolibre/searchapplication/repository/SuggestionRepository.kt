package com.mercadolibre.searchapplication.repository

import com.mercadolibre.core.resultWrapper.ResultWrapper
import com.mercadolibre.searchapplication.data.api.ApiSuggestion
import com.mercadolibre.searchapplication.domain.models.AutoSuggestion
import com.mercadolibre.searchapplication.domain.repositories.ISuggestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.mapLatest

class SuggestionRepository(private val apiSuggestion: ApiSuggestion) : ISuggestionRepository {
    override suspend fun getSuggestionByQuery(query: String): Flow<ResultWrapper<AutoSuggestion>> =
        flowOf(apiSuggestion.getAutoSuggestions(query).toAutosuggestion())
            .catch { exc -> ResultWrapper.Error(exc.message.toString()) }
            .mapLatest { ResultWrapper.Success(it) }
}
