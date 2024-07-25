package com.meneses.appliverpool.data

import com.meneses.appliverpool.data.network.ProductService
import com.meneses.appliverpool.data.response.liverpool.Record
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val service: ProductService
) {

    suspend fun getProducts(search: String): List<Record> {
        var listRecord = listOf<Record>()
        kotlin.runCatching {
            service.getProduct(search = search) {
                listRecord = it.data?.plpResults!!.records
            }
        }.onSuccess { return listRecord }
            .onFailure { return listRecord }
        return listRecord
    }
}