package com.mercadolibre.searchapplication.presentation.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.databinding.FragmentSearchBinding
import com.mercadolibre.searchapplication.presentation.fragments.search.SearchSuggestionContract.Presenter
import com.mercadolibre.searchapplication.presentation.fragments.search.adapter.SuggestionAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SearchFragment : Fragment(), SearchSuggestionContract.View, SuggestedCallback {

    private lateinit var suggestionAdapter: SuggestionAdapter

    override val presenter by inject<Presenter>()

    lateinit var binding: FragmentSearchBinding

    //Todo Crear base
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        suggestionAdapter = SuggestionAdapter(this)
        binding.recyclerViewSuggestion.adapter = suggestionAdapter
        binding.editextSearchProducts.addTextChangedListener(presenter)
    }

    override fun suggestedOnClick(query: String) {
        val action = SearchFragmentDirections.actionSearchFragmentToMainFragment(query)
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
        suggestionAdapter.submitList(emptyList())
        with(binding) {
            viewStubClearText.run {
                if (layoutResource == 0) {
                    layoutResource = R.layout.search_clear_layout
                    inflate()
                }
                visibility = View.VISIBLE
            }
        }
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
                    visibility = View.VISIBLE
                }
            }
        }
    }

}
