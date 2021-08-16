package com.mercadolibre.searchapplication.presentation.fragments.productResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.databinding.FragmentProductsResultBinding
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.presentation.fragments.productResult.adapter.ProductsAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ProductsResultFragment : Fragment(), ProductResultContract.View {

    private lateinit var productsAdapter: ProductsAdapter

    override val presenter by inject<ProductResultContract.Presenter>()

    private var binding: FragmentProductsResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsResultBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        productsAdapter = ProductsAdapter()
        binding?.setupViews()
    }

    override fun onResume() {
        super.onResume()
        presenter.getProducts("Iphone")
    }

    override fun showProducts(products: PagingData<Product>) {
        lifecycleScope.launch {
            productsAdapter.submitData(products)
        }
    }

    private fun FragmentProductsResultBinding.setupViews() {
        recyclerViewProductsResult.run {
            adapter = productsAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(context, R.drawable.recycler_divider)?.let {
                    setDrawable(it)
                }
            })
        }
    }

}
