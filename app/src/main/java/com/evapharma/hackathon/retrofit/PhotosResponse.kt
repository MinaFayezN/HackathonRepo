package com.evapharma.hackathon.retrofit


class Photos : ArrayList<PhotosItem>()

data class PhotosItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)