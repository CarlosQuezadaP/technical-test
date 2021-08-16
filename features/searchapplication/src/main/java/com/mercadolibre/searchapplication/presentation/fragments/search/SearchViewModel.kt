package com.mercadolibre.searchapplication.presentation.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.core.resultWrapper.ResultWrapper
import com.mercadolibre.searchapplication.domain.models.AutoSuggestion
import com.mercadolibre.searchapplication.domain.usecases.GetSuggestionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SearchViewModel(private val suggestionsUseCase: GetSuggestionsUseCase) : ViewModel() {

    private var _suggestions: MutableLiveData<ResultWrapper<AutoSuggestion>> = MutableLiveData()
    var suggestions: LiveData<ResultWrapper<AutoSuggestion>> = _suggestions

    fun getSuggestions(query: String) {
        viewModelScope.launch {
            suggestionsUseCase.invoke(query)
                .onStart { ResultWrapper.Loading }
                .flowOn(Dispatchers.IO)
                .collect {
                    _suggestions.value = it
                }
        }
    }

}
