package com.mercadolibre.searchapplication.domain.usecases

import com.mercadolibre.core.resultWrapper.ResultWrapper
import com.mercadolibre.searchapplication.domain.models.AutoSuggestion
import com.mercadolibre.searchapplication.domain.repositories.ISuggestionRepository
import kotlinx.coroutines.flow.Flow

class GetSuggestionsUseCase(private val iSuggestionRepository: ISuggestionRepository) {

    suspend operator fun invoke(query: String): Flow<ResultWrapper<AutoSuggestion>> {
        return iSuggestionRepository.getSuggestionByQuery(query)
    }
}
