package com.meneses.appliverpool.data.response.liverpool

data class Navigation(
    val ancester: List<Ancester>,
    val childs: List<Any>,
    val current: List<Current>
)