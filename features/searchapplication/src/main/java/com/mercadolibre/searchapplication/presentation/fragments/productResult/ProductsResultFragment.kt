package com.mercadolibre.searchapplication.presentation.fragments.productResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import com.mercadolibre.searchapplication.R
import com.mercadolibre.searchapplication.base.BaseFragment
import com.mercadolibre.searchapplication.databinding.FragmentProductsResultBinding
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.presentation.fragments.productResult.adapter.ProductsAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ProductsResultFragment : BaseFragment(), ProductResultContract.View, ProductCallback {

    private lateinit var productsAdapter: ProductsAdapter

    override val presenter by inject<ProductResultContract.Presenter>()

    private var binding: FragmentProductsResultBinding? = null

    private val productsResultFragmentArgs: ProductsResultFragmentArgs by navArgs()

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
        productsAdapter = ProductsAdapter(this)
        val query = productsResultFragmentArgs.query
        binding?.setupViews(query)
        presenter.getProducts(query)
    }

    private fun navigateToSearchFragment(text: String) {
        val action = ProductsResultFragmentDirections.actionProductResultToSearchFragment(
            text
        )
        findNavController().navigate(action)
    }

    override fun showProducts(products: PagingData<Product>) {
        lifecycleScope.launch {
            productsAdapter.submitData(products)
        }
    }

    override fun showLoading() {
        binding?.circularDeterminativePb?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        lifecycleScope.launch {
            binding?.circularDeterminativePb?.visibility = View.GONE
        }
    }

    private fun FragmentProductsResultBinding.setupViews(query: String) {

        incSearch.editextSearchProduct.let { editextSearch ->
            editextSearch.setText(query)
            editextSearch.setOnClickListener {
                navigateToSearchFragment(editextSearch.text.toString())
            }
        }
        textViewCancel.setOnClickListener {
            navigateToSearchFragment("")
        }
        recyclerViewProductsResult.run {
            adapter = productsAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(context, R.drawable.recycler_divider)?.let {
                    setDrawable(it)
                }
            })
        }
    }

    override fun onProductClick(product: Product) {
        val action = ProductsResultFragmentDirections.actionProductResultToDetailFragment(product)
        findNavController().navigate(action)
    }



}
