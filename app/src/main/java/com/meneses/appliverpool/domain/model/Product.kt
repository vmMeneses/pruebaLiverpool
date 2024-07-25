package com.meneses.appliverpool.domain.model

data class Product(
    val nombre:String,
    val imagen:String,
    val precioDesc:String,
    val precioSinDesc:String,
    val listColores: List<String> = listOf()


)
