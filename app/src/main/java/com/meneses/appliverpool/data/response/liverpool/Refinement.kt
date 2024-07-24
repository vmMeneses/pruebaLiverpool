package com.meneses.appliverpool.data.response.liverpool

data class Refinement(
    val colorHex: String,
    val count: Int,
    val high: String,
    val label: String,
    val low: String,
    val refinementId: String,
    val searchName: String,
    val selected: Boolean,
    val type: String
)