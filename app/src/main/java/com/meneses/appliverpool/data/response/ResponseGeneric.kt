package com.meneses.appliverpool.data.response

import com.meneses.appliverpool.data.response.liverpool.ResponseLiverpool

data class ResponseGeneric(
    val data: ResponseLiverpool?,
    val msg:String
)
