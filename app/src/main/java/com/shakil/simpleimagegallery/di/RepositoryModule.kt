package com.shakil.simpleimagegallery.di

import com.shakil.simpleimagegallery.domain.repository.GalleryRepository
import com.shakil.simpleimagegallery.domain.repository.GalleryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindGalleryRepo(galleryRepositoryImpl: GalleryRepositoryImpl): GalleryRepository
}