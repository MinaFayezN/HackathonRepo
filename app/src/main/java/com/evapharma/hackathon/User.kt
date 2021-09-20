package com.evapharma.hackathon

data class User(
    val fName: String,
    val sName: String,
    val email: String,
    val imageLink: String = "https://icon-library.com/images/android-profile-icon/android-profile-icon-2.jpg",
    val imageResource: Int = R.drawable.profile,
    val isAdmin: Boolean = false,
)
