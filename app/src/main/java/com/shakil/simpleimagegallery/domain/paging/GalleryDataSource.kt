package com.shakil.simpleimagegallery.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shakil.simpleimagegallery.domain.mapper.PhotoModelMapper
import com.shakil.simpleimagegallery.domain.model.GalleryPagingKey
import com.shakil.simpleimagegallery.domain.model.PhotoModel
import com.shakil.simpleimagegallery.remote.response.UnsplashApiService
import com.shakil.simpleimagegallery.util.tags

class GalleryDataSource(
    private val initialKey: GalleryPagingKey,
    private val unsplashApiService: UnsplashApiService,
    private val photoModelMapper: PhotoModelMapper,
) : PagingSource<GalleryPagingKey, PhotoModel>() {


    override suspend fun load(params: LoadParams<GalleryPagingKey>): LoadResult<GalleryPagingKey, PhotoModel> {
        return try {
            val requestParam = params.key ?: initialKey

            val data = unsplashApiService.searchPhotos(
                query = requestParam.query ?: tags[0].tagName,
                page = requestParam.pageNumber,
                numOfPhotos = requestParam.pageSize
            )

            LoadResult.Page(
                data =  photoModelMapper.map(data = data),
                prevKey = null,
                nextKey = createNextKey(requestParam,data.total ?: 0),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun createNextKey(
        currentKey: GalleryPagingKey,
        totalResults: Int
    ): GalleryPagingKey? {
        val currentMaxResults = currentKey.pageSize * currentKey.pageNumber

        return if (currentMaxResults < totalResults) {
            currentKey.copy(pageNumber = currentKey.pageNumber + 1)
        } else {
            null
        }
    }

    override fun getRefreshKey(state: PagingState<GalleryPagingKey, PhotoModel>): GalleryPagingKey? {
        return null
    }
}