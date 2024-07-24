package com.meneses.appliverpool.data.response.liverpool

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("status")val status: String,
    @SerializedName("statusCode")val statusCode: Int
)