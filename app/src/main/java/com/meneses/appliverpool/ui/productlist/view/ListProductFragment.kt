package com.meneses.appliverpool.ui.productlist.view

import android.R
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.meneses.appliverpool.databinding.FragmentListProductBinding
import com.meneses.appliverpool.ui.productlist.adapter.AdapterProduct
import com.meneses.appliverpool.ui.productlist.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Arrays

@AndroidEntryPoint
class ListProductFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentListProductBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductListViewModel by viewModels()
    private lateinit var productAdapter: AdapterProduct

    private lateinit var   optionSpinner:ArrayAdapter<String>


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

        binding.ButtonSearch.setOnClickListener {
            val word = binding.EditTextSearch.text.toString().trim()
            Log.e("ResponseGeneric", "=> $word")
            if (word.length > 6) {
                productViewModel.getProductSerachWord(word)
                hideKeyboard()
            }
        }
        setupSpinner()
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
        productViewModel.isLoading.observe(viewLifecycleOwner) { isVisible ->
            binding.progressbaProducts.visibility = if (isVisible) View.VISIBLE else View.GONE
        }

        productViewModel.dataProducts.observe(viewLifecycleOwner) { listData ->
            productAdapter.updateListProducts(listData)
        }
    }

    private fun initUIState() {

    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        view.let {
            imm.hideSoftInputFromWindow(it?.windowToken, 0)
        }
    }

    private fun setupSpinner() {
        optionSpinner = ArrayAdapter<String>(
            requireContext(), R.layout.simple_spinner_dropdown_item
        )
        optionSpinner.addAll(Arrays.asList("Ordenar", "Mayor precio", "Menor precio"))
        binding.SpinnerOrdenar.onItemSelectedListener = this
        binding.SpinnerOrdenar.adapter = optionSpinner
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val optionSelect = optionSpinner.getItem(position)
        if(!optionSelect!!.isEmpty()){
            Toast.makeText(requireContext(), "Productos ordenados $position  = $optionSelect", Toast.LENGTH_SHORT).show()
            //Se manda a llamar el caso de uso de ordenamiento
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}