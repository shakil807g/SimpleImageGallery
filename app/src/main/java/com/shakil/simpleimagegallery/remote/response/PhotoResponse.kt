package com.shakil.simpleimagegallery.remote.response

import com.google.gson.annotations.Expose

data class PhotoResponse (
    @Expose val id: String,
    @Expose val created_at: String,
    @Expose val color: String,
    @Expose val description: String,
    @Expose val urls: PhotoUrlsResponse,
    @Expose val user: UserResponse
)