package com.mercadolibre.searchapplication.presentation.fragments.detail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.mercadolibre.searchapplication.base.BaseFragment
import com.mercadolibre.searchapplication.databinding.FragmentDetailBinding
import com.mercadolibre.searchapplication.domain.models.Product
import com.mercadolibre.searchapplication.extensions.loadImageFromUrl
import org.koin.android.ext.android.inject
import androidx.appcompat.app.AppCompatActivity
import android.view.*


class DetailFragment : BaseFragment() {


    private val viewModelDetail by inject<ProductDetailViewModel>()
    lateinit var fragmentDetailBinding:FragmentDetailBinding


    private val productDetailFragmentArgs:DetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDetailBinding = FragmentDetailBinding.inflate(layoutInflater)
        return fragmentDetailBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = productDetailFragmentArgs.product
        configureView(product)
        bindProductToView(product)

        viewModelDetail.getProductDetail(product.id)

        viewModelDetail.detail.observe(requireActivity(),{
            fragmentDetailBinding.incContentDescription.textViewProductDescription.text = it
        })
    }

    private fun configureView(product:Product) {
        fragmentDetailBinding.toolbar.let {
            val appCompatActivity = (activity as AppCompatActivity?)
            appCompatActivity?.setSupportActionBar(it)
            appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            appCompatActivity?.supportActionBar?.setDisplayShowHomeEnabled(true)
            it.title = product.name
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return false
    }

    private fun bindProductToView(product:Product){
        with(fragmentDetailBinding){
            imageViewProduct.loadImageFromUrl(product.image)
        }
    }

}
