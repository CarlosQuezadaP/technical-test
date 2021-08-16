package com.mercadolibre.searchapplication.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}
