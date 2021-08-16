package com.mercadolibre.searchapplication.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.text.NumberFormat

fun ImageView.loadImageFromUrl(url: String) {
    Picasso.get()
        .load(url.replace("http:", "https://"))
        .fit()
        .centerCrop()
        .into(this)
}

fun formatPrice(price: Long): String {
    val format = NumberFormat.getCurrencyInstance().apply { maximumFractionDigits = 0 }
    return format.format(price).replace(",", ".")
}

fun formatPrice(price: Double): String {
    val format = NumberFormat.getCurrencyInstance().apply { maximumFractionDigits = 0 }
    return format.format(price).replace(",", ".")
}
