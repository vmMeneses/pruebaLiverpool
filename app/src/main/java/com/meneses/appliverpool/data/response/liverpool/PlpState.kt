package com.meneses.appliverpool.data.response.liverpool

data class PlpState(
    val categoryId: String,
    val currentFilters: String,
    val currentSortOption: String,
    val firstRecNum: Int,
    val lastRecNum: Int,
    val originalSearchTerm: String,
    val plpSellerName: String,
    val recsPerPage: Int,
    val totalNumRecs: Int
)