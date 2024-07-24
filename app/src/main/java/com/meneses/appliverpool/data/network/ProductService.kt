package com.meneses.appliverpool.data.network

import com.meneses.appliverpool.data.response.ResponseGeneric
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService @Inject constructor(
    private val apiClient: ApiClientProduct
) {


    suspend fun getProduct(search:String, response:(ResponseGeneric) -> Unit) {
        withContext(Dispatchers.IO){
           val response =  apiClient.getProducts(search = search)
            if(response.body() != null){
                response(
                    ResponseGeneric(
                        data=response.body(),
                        msg = "Petición exitosa"
                    )
                )
            }else{
                response(
                    ResponseGeneric(
                        data=null,
                        msg = "Petición exitosa"
                    )
                )
            }
        }
    }
}