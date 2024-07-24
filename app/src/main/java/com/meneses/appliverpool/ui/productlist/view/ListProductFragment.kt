package com.meneses.appliverpool.ui.productlist.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.meneses.appliverpool.databinding.FragmentListProductBinding
import com.meneses.appliverpool.ui.productlist.adapter.AdapterProduct
import com.meneses.appliverpool.ui.productlist.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListProductFragment : Fragment() {

    private var _binding:FragmentListProductBinding?= null
    private val binding get() = _binding!!

    private val productViewModel: ProductListViewModel by viewModels()
    private lateinit var productAdapter:AdapterProduct


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecycler()
        initUIState()
        initObserver()
        /*binding.EditTextSearch.addTextChangedListener {

        }*/
        binding.ButtonSearch.setOnClickListener {
            val word = binding.EditTextSearch.text.toString().trim()
            Log.e("ResponseGeneric","=> $word")
            if(word.length > 10){
                productViewModel.getProductSerachWord(word)
            }
        }
    }

    private fun initRecycler() {
        productAdapter = AdapterProduct()

        binding.RecyclerviewProducts.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun initObserver() {


        productViewModel.isLoading.observe(viewLifecycleOwner){  isVisible ->
            binding.progressbaProducts.visibility= if (isVisible) View.VISIBLE else View.GONE
        }

        productViewModel.dataProducts.observe(viewLifecycleOwner){ listData ->
            productAdapter.updateListProducts(listData)
        }
    }

    private fun initUIState() {

    }


}