package com.meneses.appliverpool.domain.useCase

import android.util.Log
import com.meneses.appliverpool.data.ProductRepository
import com.meneses.appliverpool.data.response.liverpool.Record
import javax.inject.Inject

class GetSearchByWordProduct @Inject constructor(
    private val productRepository: ProductRepository
){

    suspend operator fun invoke(search:String, responseData: (List<Record>) ->Unit) {
        productRepository.getProducts(search) {
            Log.e("ResponseGeneric"," ${it.msg}")
            Log.e("ResponseGeneric"," ${it.data}")
            if(it.data != null){
                it.data?.plpResults?.records?.let { listData -> responseData(listData) }
            }
        }


    }

}