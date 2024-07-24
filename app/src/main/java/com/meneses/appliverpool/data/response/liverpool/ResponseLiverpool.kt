package com.meneses.appliverpool.data.response.liverpool

import com.google.gson.annotations.SerializedName

data class ResponseLiverpool(
   @SerializedName("pageType") val pageType: String,
   @SerializedName("plpResults") val plpResults: PlpResults,
   @SerializedName("status") val status: Status
)