package com.mercadolibre.searchapplication.presentation.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.base.BaseFragment
import com.mercadolibre.searchapplication.databinding.FragmentSearchBinding
import com.mercadolibre.searchapplication.presentation.fragments.search.SearchSuggestionContract.Presenter
import com.mercadolibre.searchapplication.presentation.fragments.search.adapter.SuggestionAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment(), SearchSuggestionContract.View, SuggestedCallback {

    private lateinit var suggestionAdapter: SuggestionAdapter

    override val presenter by inject<Presenter>()

    private lateinit var binding: FragmentSearchBinding

    private val searchFragmentArgs: SearchFragmentArgs? by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        presenter.view = this
        lifecycle.addObserver(presenter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        suggestionAdapter = SuggestionAdapter(this)
        binding.recyclerViewSuggestion.adapter = suggestionAdapter
        binding.editextSearchProducts.addTextChangedListener(presenter)
        searchFragmentArgs?.query?.let {
            binding.editextSearchProducts.setText(it)
        }
    }

    override fun suggestedOnClick(query: String) {
        hideKeyboard()
        val action = SearchFragmentDirections.actionSearchFragmentToProductResultFragment(query)
        findNavController().navigate(action)
    }

    override fun showSuggestions(list: List<String>) {
        lifecycleScope.launch {
            suggestionAdapter.submitList(list)
        }
    }

    override fun hideEmptyResult() {
        lifecycleScope.launch {
            with(binding) {
                viewStubEmpty.visibility = View.GONE
                recyclerViewSuggestion.visibility = View.VISIBLE
            }
        }
    }

    override fun hideList() {
        lifecycleScope.launch {
            binding.recyclerViewSuggestion.visibility = View.GONE
        }
    }

    override fun showList() {
        lifecycleScope.launch {
            binding.recyclerViewSuggestion.visibility = View.VISIBLE
        }
    }

    override fun showEmptySearch() {
        if (::suggestionAdapter.isInitialized) {
            suggestionAdapter.submitList(emptyList())
        }
        with(binding) {
            viewStubClearText.run {
                if (layoutResource == 0) {
                    layoutResource = R.layout.search_clear_layout
                    inflate()
                }
                visibility = View.VISIBLE
            }
        }
        hideKeyboard()
    }

    override fun hideEmptySearch() {
        lifecycleScope.launch {
            binding.viewStubClearText.visibility = View.GONE
        }
    }

    override fun showEmptyResult() {
        lifecycleScope.launch {
            with(binding) {
                viewStubEmpty.run {
                    if (layoutResource == 0) {
                        layoutResource = R.layout.search_empty_layout
                        inflate()
                    }
                    if (visibility != View.VISIBLE) {
                        visibility = View.VISIBLE
                    }
                }
            }
        }
    }

}
