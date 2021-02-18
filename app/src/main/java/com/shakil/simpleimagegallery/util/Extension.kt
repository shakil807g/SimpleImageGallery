package com.shakil.simpleimagegallery.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems


fun String.initials(): String {
    return this.split(' ')
        .mapNotNull { it.firstOrNull()?.toString() }
        .reduce { acc, s -> acc + s }
}

@ExperimentalFoundationApi
fun <T : Any> LazyGridScope.itemsGridIndexed(
        lazyPagingItems: LazyPagingItems<T>,
        itemContent: @Composable LazyItemScope.(index: Int, value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        if(lazyPagingItems.itemCount - 1 >= index) {
            val item = lazyPagingItems[index]
            itemContent(index, item)
        }
    }
}




fun hideKeyboard(activity: Activity) {
    val imm: InputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = activity.currentFocus
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

class Ref(var value: Int)

const val EnableDebugCompositionLogs = true

