package com.shakil.simpleimagegallery.remote.response


import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {

    @GET("photos")
    suspend fun loadPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") numOfPhotos: Int = 10,
        @Query("order_by") orderBy: String = "popular"
    ): List<PhotoResponse>

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") numOfPhotos: Int = 10,
    ): SearchPhotosResponse

    companion object {
        const val BASE_API_URL = "https://api.unsplash.com/"
    }
}