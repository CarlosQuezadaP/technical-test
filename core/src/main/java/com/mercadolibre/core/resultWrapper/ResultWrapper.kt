package com.mercadolibre.core.resultWrapper

sealed class ResultWrapper<out T> {
    class Success<out T: Any>(val data: T): ResultWrapper<T>()
    data class Error(val message: String) : ResultWrapper<Nothing>()
    object Loading : ResultWrapper<Nothing>()
}
