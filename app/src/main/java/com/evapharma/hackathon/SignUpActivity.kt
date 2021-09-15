package com.evapharma.hackathon

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val name = intent.extras?.get(EXTRA_NAME_KEY) ?: ""
        findViewById<TextView>(R.id.tv_signup_title).text = name.toString()
    }


    override fun onBackPressed() {
        setResult(SIGNUP_DATA_RESULT_CODE, Intent().apply {
            putExtra(NEW_NAME, "this is a new name")
        })
        super.onBackPressed()
    }
}