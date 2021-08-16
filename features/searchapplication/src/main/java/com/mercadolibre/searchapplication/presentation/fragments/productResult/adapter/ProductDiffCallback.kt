package com.mercadolibre.searchapplication.presentation.fragments.productResult.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mercadolibre.searchapplication.domain.models.Product

class ProductDiffCallback: DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
