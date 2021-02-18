package com.shakil.simpleimagegallery.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SearchPhotosResponse(
    @Expose @SerializedName("total") val total: Int,
    @Expose @SerializedName("total_pages") val totalPages: Int,
    @Expose @SerializedName("results") val photosList: List<PhotoResponse>
)