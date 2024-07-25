package com.meneses.appliverpool.ui.productlist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meneses.appliverpool.data.response.liverpool.Record
import com.meneses.appliverpool.domain.useCase.GetSearchByWordProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
  private val getProductWord: GetSearchByWordProduct
):ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val dataProducts = MutableLiveData<List<Record>>()


    fun getProductSerachWord(search:String =""){
        viewModelScope.launch {
            isLoading.postValue(true)
            dataProducts.value = getProductWord(search)
            isLoading.postValue(false)
        }
    }

}