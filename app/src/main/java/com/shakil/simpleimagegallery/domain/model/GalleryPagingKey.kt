package com.shakil.simpleimagegallery.domain.model

data class GalleryPagingKey(
    val pageNumber: Int = 1,
    val pageSize: Int = 20,
    val orderBy: String = "popular",
    val query: String? = null
)