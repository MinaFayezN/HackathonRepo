package com.evapharma.hackathon.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com"

class JSONRetriever {
    private val service: JSONHolderService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(JSONHolderService::class.java)
    }

    fun getPosts() = service.retrievePosts()
    fun getPhotos() = service.retrievePhotos()
    fun doSearch() = service.postId("asdasdas")
}