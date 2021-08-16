package com.mercadolibre.searchapplication.presentation.fragments.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mercadolibre.searchapplication.databinding.SearchResultItemBinding
import com.mercadolibre.searchapplication.presentation.fragments.search.SuggestedCallback

class SuggestionViewHolder(
    itemView: SearchResultItemBinding,
    private val suggestedCallback: SuggestedCallback
) : RecyclerView.ViewHolder(itemView.root) {

    private val binding = itemView

    fun bind(suggestion: String) {
        binding.textViewSuggestion.run {
            text = suggestion
            setOnClickListener {
                suggestedCallback.suggestedOnClick(suggestion)
            }
        }
    }
}
