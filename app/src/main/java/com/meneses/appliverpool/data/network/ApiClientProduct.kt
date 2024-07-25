package com.meneses.appliverpool.data.network

import com.meneses.appliverpool.data.response.liverpool.ResponseLiverpool
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClientProduct {

    @GET("/appclienteservices/services/v3/plp")
    suspend fun getProducts(
        @Query("search-string") search:String = "Iphone 15",
        @Query("page-number") page :Int = 1
    ): ResponseLiverpool

}