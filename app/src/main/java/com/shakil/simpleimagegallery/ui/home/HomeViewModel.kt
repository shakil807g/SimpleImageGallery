package com.shakil.simpleimagegallery.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shakil.simpleimagegallery.domain.model.GalleryPagingKey
import com.shakil.simpleimagegallery.domain.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val facrRepository: GalleryRepository,
) : ViewModel() {

    private val galleryPaging: MutableStateFlow<GalleryPagingKey> =
        MutableStateFlow(GalleryPagingKey())

    val galleryList = galleryPaging
        .flatMapLatest { pagingKey -> facrRepository.searchPhotos(pagingKey) }
        .cachedIn(viewModelScope)

    fun setSearchQuery(text: String) {
        galleryPaging.value = galleryPaging.value.copy(query = if (text.isEmpty()) null else text)
    }

}