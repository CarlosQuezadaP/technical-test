package com.mercadolibre.searchapplication.presentation.fragments.productResult.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.mercadolibre.searchapplication.databinding.ProductResultItemBinding
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.presentation.fragments.productResult.ProductCallback

class ProductsAdapter(private val productCallback: ProductCallback) :
    PagingDataAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemBinding = ProductResultItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(itemBinding, productCallback)
    }

}
