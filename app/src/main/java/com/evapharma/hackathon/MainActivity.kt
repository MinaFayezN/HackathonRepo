package com.evapharma.hackathon

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Threads", Thread.currentThread().name)
        findViewById<Button>(R.id.btn_thread).setOnClickListener {
            progressBar.visibility = View.VISIBLE
            createThreadAndCall()
        }
        progressBar = findViewById(R.id.progressBar)
    }

    private fun createThreadAndCall() {
        object : Thread() {
            override fun run() {
                super.run()
                val result = callAPI()
                val posts = convertJSONResultToObject(result)
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()
                }
//                adapter.updateData(posts.postsList)
            }
        }.start()
    }


    private val urlString = "https://jsonplaceholder.typicode.com/posts"

    fun callAPI(): String {
        Log.d("Threads", "starting api call on thread ${Thread.currentThread().name}")
        val url = URL(urlString)
        val httpURLConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.connect()
        val inputStream = httpURLConnection.inputStream
        val inReader = InputStreamReader(inputStream)
        val bufferReader = BufferedReader(inReader)
        var result = ""
        var line = ""
        while (bufferReader.readLine()?.also { line = it } != null) {
            result += line
        }
        Log.d("Threads", " api call finished with result $result")
        Thread.sleep(3000)
        return result
    }

    private val newThread = object : Thread() {
        override fun run() {
            super.run()
            Log.d("Threads", "Starting new Thread")
            Log.d("Threads", currentThread().name)
            for (i in 0..10000) {
                sleep(500)
                Log.d("Threads", "$i")
                if (i == 10) {
//                    runOnUiThread(object:Runnable{
//                        override fun run() {
//                        }
//                    })
                    runOnUiThread {
                        Log.d("Threads", currentThread().name)
                        progressBar.visibility = View.GONE
                    }
                } else if (i == 20) {
                    runOnUiThread {
                        Log.d("Threads", currentThread().name)
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
            Log.d("Threads", currentThread().name)
        }
    }
}


// Useful links
// https://www.youtube.com/watch?v=dRYnm_k3w1w
// https://www.youtube.com/user/ProgrammingKnowledge