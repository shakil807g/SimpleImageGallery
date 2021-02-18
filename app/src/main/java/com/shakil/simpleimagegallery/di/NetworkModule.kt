package com.shakil.simpleimagegallery.di

import android.content.Context
import coil.ImageLoader
import coil.util.CoilUtils
import com.google.gson.Gson
import com.shakil.simpleimagegallery.remote.response.UnsplashApiService
import com.shakil.simpleimagegallery.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                var request = chain.request()
                var newRequest = request.newBuilder().header("Authorization", AppConstants.API.API_KEY)
                chain.proceed(newRequest.build())
            }
            .cache(CoilUtils.createDefaultCache(context))
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideImageLoader(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient
    ): ImageLoader {
        return ImageLoader.Builder(context)
            .okHttpClient { okHttpClient }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(UnsplashApiService.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesUnsplashApiService(retrofit: Retrofit): UnsplashApiService {
        return retrofit.create(UnsplashApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}