package com.mercadolibre.searchapplication.presentation.fragments.search

import android.text.Editable
import com.mercadolibre.core.resultWrapper.ResultWrapper
import com.mercadolibre.searchapplication.domain.usecases.GetSuggestionsUseCase
import com.mercadolibre.searchapplication.presentation.fragments.search.SearchSuggestionContract.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchSuggestionPresenter(private val suggestionsUseCase: GetSuggestionsUseCase) :
    SearchSuggestionContract.Presenter {

    private fun getSuggestion(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val products = suggestionsUseCase.invoke(query)
            products
                .catch {
                    it.localizedMessage
                }
                .collect {
                    when (it) {
                        is ResultWrapper.Success -> view.showSuggestions(it.data.suggestions)

                        is ResultWrapper.Error -> {

                        }

                        is ResultWrapper.Loading -> {
                        }
                    }

                }
        }
    }

    override lateinit var view: View

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        print("Before: ${s.toString()}")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        print("onTextChanged: ${s.toString()}")
    }

    override fun afterTextChanged(s: Editable?) {
        val value = s.toString()
        if (value.isNotEmpty())
            getSuggestion(s.toString())
    }
}
