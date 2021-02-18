package com.shakil.simpleimagegallery.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shakil.simpleimagegallery.domain.mapper.PhotoModelMapper
import com.shakil.simpleimagegallery.domain.model.GalleryPagingKey
import com.shakil.simpleimagegallery.domain.model.PhotoModel
import com.shakil.simpleimagegallery.domain.paging.GalleryDataSource
import com.shakil.simpleimagegallery.remote.response.UnsplashApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepositoryImpl @Inject constructor(
    val unsplashApiService: UnsplashApiService,
    val mapper: PhotoModelMapper
): GalleryRepository {
    override suspend fun searchPhotos(pagingKey: GalleryPagingKey): Flow<PagingData<PhotoModel>> {
        return Pager(
            PagingConfig(
                pageSize = pagingKey.pageSize,
                prefetchDistance = pagingKey.pageSize.div(4)
            )
        ) {
            GalleryDataSource(
                initialKey = pagingKey,
                unsplashApiService = unsplashApiService,
                photoModelMapper = mapper
            )
        }.flow
    }
}