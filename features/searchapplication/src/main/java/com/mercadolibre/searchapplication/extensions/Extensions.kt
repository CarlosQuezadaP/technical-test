package com.mercadolibre.searchapplication.extensions

import android.widget.ImageView
import android.widget.ImageView.ScaleType.CENTER_CROP
import coil.load
import com.mercadolibre.searchapplication.R
import java.text.NumberFormat

fun ImageView.loadImageFromUrl(url: String) {
    load(url.replace("http:", "https://")) {
        crossfade(750)
        placeholder(R.drawable.loading_icon)
        error(R.drawable.ic_error_loading)
    }
    scaleType = CENTER_CROP
}

private fun getCurrencyInstance() =
    NumberFormat.getCurrencyInstance().apply { maximumFractionDigits = 0 }

fun Long.formatPrice() = getCurrencyInstance().format(this).replace(",", ".")

fun Double.formatPrice(): String {
    return getCurrencyInstance().format(this).replace(",", ".")
}
