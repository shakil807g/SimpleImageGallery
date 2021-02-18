package com.shakil.simpleimagegallery.domain.mapper

import coil.map.Mapper
import com.shakil.simpleimagegallery.domain.model.PhotoModel
import com.shakil.simpleimagegallery.remote.response.SearchPhotosResponse
import com.shakil.simpleimagegallery.util.failMissingField
import javax.inject.Inject

class PhotoModelMapper @Inject constructor() : Mapper<SearchPhotosResponse, List<PhotoModel>> {
    override fun map(data: SearchPhotosResponse): List<PhotoModel> {
        return if(!data.photosList.isNullOrEmpty()) {
            data.photosList.map {
                PhotoModel(id = it.id ?:  failMissingField("id"),
                    url = it.urls.regular ?: failMissingField("url"),
                    description = it.description ?: "",
                )
            }
        } else {
            emptyList()
        }
    }
}