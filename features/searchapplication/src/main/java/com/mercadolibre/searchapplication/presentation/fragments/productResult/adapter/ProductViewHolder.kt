package com.mercadolibre.searchapplication.presentation.fragments.productResult.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.databinding.ProductResultItemBinding
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.extensions.formatPrice
import com.mercadolibre.searchapplication.extensions.loadImageFromUrl

class ProductViewHolder(itemView: ProductResultItemBinding) :
    RecyclerView.ViewHolder(itemView.root) {

    private val binding = itemView

    fun bind(product: Product) {
        with(binding) {
            if (product.isFreeShipping) {
                textViewProductShipping.visibility = View.VISIBLE
            }
            imageViewProductFront.loadImageFromUrl(product.image)
            textViewProductTitle.text = product.name
            textViewProductPrice.text = product.price.formatPrice()
            product.installments?.let {
                if (product.isWithoutInterest) {
                    textViewProductPayWays.run {
                        setTextColor(ContextCompat.getColor(context, R.color.meli_green))
                        text = String.format(
                            context.getString(
                                R.string.installment_without_interest,
                                it
                            )
                        )
                    }
                } else {
                    textViewProductPayWays.run {
                        text = String.format(context.getString(R.string.installment, it))
                    }
                }
            }
            product.discount?.let {
                val discount = "$it%OFF"
                textViewProductDiscount.run {
                    text = discount
                    visibility = View.VISIBLE
                }
            }
        }
    }
}

