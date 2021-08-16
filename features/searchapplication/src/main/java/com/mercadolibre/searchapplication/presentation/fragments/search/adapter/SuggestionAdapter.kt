package com.mercadolibre.searchapplication.presentation.fragments.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mercadolibre.searchapplication.databinding.SearchResultItemBinding
import com.mercadolibre.searchapplication.presentation.fragments.search.SuggestedCallback

class SuggestionAdapter(private val suggestedCallback: SuggestedCallback) :
    ListAdapter<String, SuggestionViewHolder>(SuggestionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {

        val itemBinding = SearchResultItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SuggestionViewHolder(itemBinding, suggestedCallback)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
