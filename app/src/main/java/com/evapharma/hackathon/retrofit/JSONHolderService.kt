package com.evapharma.hackathon.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface JSONHolderService {
    @GET("/posts")
    fun retrievePosts(): Call<Posts>

    @GET("/photos")
    fun retrievePhotos(): Call<Photos>

    @POST("/post/json")
    fun postId(
                @Query("token")token  :String,

    ): Call<Photos>

}


