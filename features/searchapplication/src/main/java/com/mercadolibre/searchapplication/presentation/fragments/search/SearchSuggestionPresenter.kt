package com.mercadolibre.searchapplication.presentation.fragments.search

import android.text.Editable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
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

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreateView(){
        view.showEmptySearch()
    }

    private fun getSuggestion(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val products = suggestionsUseCase.invoke(query)
            products
                .catch {
                    it.localizedMessage
                }
                .collect {
                    when (it) {
                        is ResultWrapper.Success -> {
                            val suggestions = it.data.suggestions
                            if (suggestions.isEmpty()) {
                                view.hideList()
                                view.showEmptyResult()
                            } else {
                                view.showList()
                                view.showSuggestions(suggestions)
                                view.hideEmptyResult()
                            }
                            view.hideEmptySearch()
                        }

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
        else
            view.showEmptySearch()
            view.hideEmptyResult()
            view.hideList()
    }
}
