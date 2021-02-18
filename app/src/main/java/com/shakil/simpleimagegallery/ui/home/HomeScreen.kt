package com.shakil.simpleimagegallery.ui.home

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.shakil.simpleimagegallery.R
import com.shakil.simpleimagegallery.domain.model.PhotoModel
import com.shakil.simpleimagegallery.ui.theme.facrNormal16BodyText
import com.shakil.simpleimagegallery.ui.theme.teal200
import com.shakil.simpleimagegallery.util.AppConstants.Padding16dp
import com.shakil.simpleimagegallery.util.AppConstants.Padding8dp
import com.shakil.simpleimagegallery.util.hideKeyboard
import com.shakil.simpleimagegallery.util.itemsGridIndexed
import com.shakil.simpleimagegallery.util.scrim
import com.shakil.simpleimagegallery.util.tags
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val scrollState = rememberScrollState()
    val galleryList = homeViewModel.galleryList.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            SearchField(homeViewModel)

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .horizontalScroll(scrollState), Arrangement.spacedBy(10.dp)
            ) {
                tags.forEach {
                    Box(modifier = Modifier.clickable {
                        homeViewModel.setSearchQuery(it.tagName)
                    }) {
                        NetworkImage(
                            url = it.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .preferredSize(112.dp, 40.dp)
                                .clip(RoundedCornerShape(50))
                                .scrim(colors = listOf(Color(0x80000000), Color(0x33000000)))
                        )
                        Text(
                            it.tagName,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
                when (val refreshState = galleryList.loadState.refresh) {
                    is LoadState.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                    is LoadState.Error -> {
                    }
                    is LoadState.NotLoading -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            if (galleryList.itemCount > 0) {
                                LazyVerticalGrid(
                                    modifier = Modifier.fillMaxSize(),
                                    cells = GridCells.Fixed(2),
                                    // contentPadding = PaddingValues(top = Constants.Padding8dp)
                                ) {

                                    itemsGridIndexed(galleryList) { _, item ->
                                        item?.let {
                                            Chip(it)
                                        }
                                    }
                                }
                            } else {
                                Box(modifier = Modifier.fillMaxSize()) {

                                }
                            }
                        }
                    }
                }
                when (val appendState = galleryList.loadState.append) {
                    is LoadState.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .align(Alignment.BottomCenter)
                        )
                    }
                    is LoadState.Error -> {

                    }
                }
            }

        }

    }

}

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun Chip(photoModel: PhotoModel) {
    Box {
        NetworkImage(
            url = photoModel.url,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(4f / 3f)
                //.clip(RoundedCornerShape(10))
                .scrim(colors = listOf(Color(0x80000000), Color(0x33000000)))
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun SearchField(
    homeViewModel: HomeViewModel
) {
    val context = LocalContext.current
    val isFocus = remember { mutableStateOf(false) }
    val color = if (isFocus.value) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    var searchQuery by remember { mutableStateOf("")}

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = Padding16dp)
            .border(1.dp, color, RoundedCornerShape(4.dp))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(Padding8dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (searchQuery.isEmpty()) {
                Text(
                    text = stringResource(R.string.search_placeholder),
                    style = facrNormal16BodyText().copy(
                        color = MaterialTheme.colors.surface.copy(alpha = 0.5f),
                        textAlign = TextAlign.Left
                    )
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                BasicTextField(
                    value = searchQuery,
                    onValueChange = {
                        isFocus.value = it.isEmpty()
                        searchQuery = it
                    },
                    modifier = Modifier.weight(1f),
                    textStyle = facrNormal16BodyText().copy(textAlign = TextAlign.Left),
                    cursorColor = MaterialTheme.colors.primary,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        homeViewModel.setSearchQuery(searchQuery)
                        hideKeyboard(context as Activity)
                    })
                )

                Box(modifier = Modifier.size(40.dp)) {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                searchQuery = ""
                                homeViewModel.setSearchQuery(tags[0].tagName)
                            },
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(Icons.Default.Clear, null)
                        }
                    } else {
                        Icon(
                            painterResource(id = R.drawable.icon_search),
                            tint = MaterialTheme.colors.primary,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun NetworkImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = MaterialTheme.colors.primary,
) {
    CoilImage(
        data = url,
        modifier = modifier,
        contentDescription = contentDescription,
        contentScale = contentScale,
        loading = {
            if (placeholderColor != null) {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(placeholderColor)
                )
            }
        }, error = {
            Log.d("TAG", "NetworkImage: " + it.throwable.localizedMessage)
            if (placeholderColor != null) {
                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(teal200)
                )
            }
        }
    )
}