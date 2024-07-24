package com.meneses.appliverpool.data.response.liverpool

data class RefinementGroup(
    val dimensionName: String,
    val multiSelect: Boolean,
    val name: String,
    val refinement: List<Refinement>
)