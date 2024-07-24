package com.meneses.appliverpool.data

import com.meneses.appliverpool.data.network.ProductService
import com.meneses.appliverpool.data.response.ResponseGeneric
import javax.inject.Inject

class ProductRepository @Inject constructor(
  private val service: ProductService
) {

    suspend fun getProducts(search:String,responseService: (ResponseGeneric) ->Unit){
            service.getProduct(search = search) { responseService(it) }
    }
}