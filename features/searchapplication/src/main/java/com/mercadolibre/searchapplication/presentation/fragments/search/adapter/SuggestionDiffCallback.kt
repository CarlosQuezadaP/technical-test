package com.mercadolibre.searchapplication.presentation.fragments.search.adapter

import androidx.recyclerview.widget.DiffUtil

class SuggestionDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
