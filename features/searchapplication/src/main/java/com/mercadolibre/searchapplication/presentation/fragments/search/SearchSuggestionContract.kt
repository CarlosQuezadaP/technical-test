package com.mercadolibre.searchapplication.presentation.fragments.search

import android.text.TextWatcher
import androidx.lifecycle.LifecycleObserver
import com.mercadolibre.searchapplication.base.BasePresenter
import com.mercadolibre.searchapplication.base.BaseView

interface SearchSuggestionContract {

    interface View : BaseView<Presenter> {

        fun showSuggestions(list: List<String>)
        fun showEmptySearch()
        fun hideEmptySearch()
        fun showEmptyResult()
        fun hideEmptyResult()
        fun hideList()
        fun showList()
    }

    interface Presenter : BasePresenter<View>, TextWatcher, LifecycleObserver
}
