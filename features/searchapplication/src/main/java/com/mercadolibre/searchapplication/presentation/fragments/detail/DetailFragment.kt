package com.mercadolibre.searchapplication.presentation.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.base.BaseFragment
import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductResultContract
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : BaseFragment() {


    private val viewModelDetail by inject<SearchViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}
