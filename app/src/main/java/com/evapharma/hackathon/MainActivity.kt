package com.evapharma.hackathon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textview_main_title)
        // Will be explained later
        object : Thread() {
            override fun run() {
                super.run()
                // API Call
                sleep(3000)
                runOnUiThread {
                    textView.text = "Hey Application askjgdaljsdgajs"
                }

            }
        }.start()

        val button = findViewById<Button>(R.id.btn_login)

        //

        /*

         */
        /**
         *
         */
    }

    /**
     * To be used for adding of two numbers
     *
     * @param first is the first number
     * @param second is the second number
     *
     * @return the sum of provided two numbers
     */
    fun sum(first: Int, second: Int): Int = first + second

    var name: String = ""
        private set
}