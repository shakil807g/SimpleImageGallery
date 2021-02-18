package com.shakil.simpleimagegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.material.ExperimentalMaterialApi
import com.shakil.simpleimagegallery.ui.home.HomeScreen
import com.shakil.simpleimagegallery.ui.home.HomeViewModel
import com.shakil.simpleimagegallery.ui.theme.SimpleImageGalleryTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalLayout
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleImageGalleryTheme {
                HomeScreen(homeViewModel)
            }
        }
    }
}