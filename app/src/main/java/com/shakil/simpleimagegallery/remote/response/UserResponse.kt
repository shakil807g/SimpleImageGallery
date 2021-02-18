package com.shakil.simpleimagegallery.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize


data class UserResponse(
    @Expose val id: String,
    @Expose val username: String,
    @Expose val name: String
//    @Expose val profile_image: String
)