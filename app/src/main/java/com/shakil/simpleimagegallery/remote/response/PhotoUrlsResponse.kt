package com.shakil.simpleimagegallery.remote.response

import com.google.gson.annotations.Expose

data class PhotoUrlsResponse(
    @Expose val raw: String,
    @Expose val full: String,
    @Expose val regular: String,
    @Expose val small: String,
    @Expose val thumb: String
)