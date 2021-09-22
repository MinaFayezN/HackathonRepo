package com.evapharma.hackathon.retrofit

class Posts(val postsList: ArrayList<PostsItem>)

data class PostsItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)


