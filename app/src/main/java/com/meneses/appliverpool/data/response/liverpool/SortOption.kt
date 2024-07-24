package com.meneses.appliverpool.data.response.liverpool

import com.google.gson.annotations.SerializedName

data class SortOption(
    @SerializedName("label")val label: String,
    @SerializedName("sortBy")val sortBy: String
)