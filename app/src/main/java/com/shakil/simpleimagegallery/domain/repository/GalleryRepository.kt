package com.shakil.simpleimagegallery.domain.repository

import androidx.paging.PagingData
import com.shakil.simpleimagegallery.domain.model.GalleryPagingKey
import com.shakil.simpleimagegallery.domain.model.PhotoModel
import com.shakil.simpleimagegallery.remote.response.PhotoResponse
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
   // suspend fun loadPhotos(pagingKey: GalleryPagingKey): Flow<PagingData<List<PhotoResponse>>>
    suspend fun searchPhotos(pagingKey: GalleryPagingKey): Flow<PagingData<PhotoModel>>
}