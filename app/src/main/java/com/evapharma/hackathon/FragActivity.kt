package com.evapharma.hackathon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FragActivity : AppCompatActivity(), LoginFragmentInteraction {

    lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)
        username = findViewById(R.id.et_username)
        findViewById<Button>(R.id.btn_frag).setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val loginFragment = LoginFragment.newInstance(username.text.toString())
            transaction.replace(R.id.frame, loginFragment).addToBackStack("LoginFragment").commit()
        }
    }

    override fun onNameClicked(name: String) {
        username.setText(name)
    }

    fun setName(name: String) {
        username.setText(name)
    }
}