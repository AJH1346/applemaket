package com.example.applemarket

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    val name: String,
    val price: String,
    val image: Int,
    val address : String,
    val like : String,
    val chat : String,
    val username : String,
    val content : String
) : Parcelable