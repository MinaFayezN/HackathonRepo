package com.evapharma.hackathon

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.evapharma.hackathon.retrofit.BASE_URL
import com.evapharma.hackathon.retrofit.JSONRetriever
import com.evapharma.hackathon.retrofit.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        findViewById<Button>(R.id.btn_retro).setOnClickListener {

            val photosCall: Call<Photos> = JSONRetriever().getPhotos()
            photosCall.enqueue(object : Callback<Photos> {
                override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                    Log.d("Photos", response.body()?.toString() ?: "No Data")
                    // adapter.updateData(response.body())
                    Toast.makeText(this@RetrofitActivity, "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Photos>, t: Throwable) {

                }
            })
        }
    }
}