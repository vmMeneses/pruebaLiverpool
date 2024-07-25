package com.meneses.appliverpool.domain.useCase

import android.util.Log
import com.meneses.appliverpool.data.ProductRepository
import com.meneses.appliverpool.data.response.liverpool.Record
import javax.inject.Inject

class GetSearchByWordProduct @Inject constructor(
    private val productRepository: ProductRepository
){

    suspend operator fun invoke(search:String) =  productRepository.getProducts(search)
        //Log.e("ListProducts"," ==> $listProducts")


}