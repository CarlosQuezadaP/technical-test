package com.mercadolibre.searchapplication.presentation.fragments.search

import android.text.TextWatcher
import com.mercadolibre.searchapplication.base.BasePresenter
import com.mercadolibre.searchapplication.base.BaseView

interface SearchSuggestionContract {

    interface View : BaseView<Presenter> {

        fun showSuggestions(list:List<String>)
    }

    interface Presenter : BasePresenter<View>,TextWatcher  {


    }
}
