package com.mercadolibre.searchapplication.presentation.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.searchapplication.domain.usecases.GetProductDetailUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val productDetailUseCase: GetProductDetailUseCase) : ViewModel() {

    private var _detail: MutableLiveData<String> = MutableLiveData()
    var detail: LiveData<String> = _detail

    fun getProductDetail(productID: String) {
        viewModelScope.launch {
            productDetailUseCase(productID).collect {
                it.fold({ error ->
                    _detail.value = error.message
                }, { productDescription ->
                    _detail.value = productDescription
                })
            }
        }
    }

}
