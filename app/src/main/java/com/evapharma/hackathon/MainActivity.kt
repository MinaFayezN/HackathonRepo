package com.evapharma.hackathon

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener, C {

    var email: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.et_email)
        initLoginButton()
        initSignUp()
        //region Explain anonymous
//        val a = A()
//        a.setInterfaceC(this)
//        a.setInterfaceC(object : C {
//            override fun doOperations(id: Int) {
//
//            }
//        })
//        a.execute()
//        //         a.setInterfaceC(new C(){
//        //         @Override
//        //        public doOperations(int id){
//        //        lsdfjsldfsd
//        //        }
//        //         })
        //endregion
    }

    private fun initLoginButton() {
        val loginBtn = findViewById<Button>(R.id.btn_login)
        loginBtn.setOnClickListener {
            val emailText = email?.text.toString().trim()
            when {
                emailText.isEmpty() -> Toast.makeText(
                    this@MainActivity,
                    "Email cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
                Patterns.EMAIL_ADDRESS.matcher(emailText).matches().not() -> {
                    email?.error = "Enter valid email"
                    Toast.makeText(this@MainActivity, "Enter a valid email", Toast.LENGTH_LONG)
                        .show()
                }
                else -> {
                    email?.error = null
                    Toast.makeText(this@MainActivity, "Login Clicked", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun initSignUp() {
        val signUpBtn = findViewById<Button>(R.id.btn_signup)
        signUpBtn.setOnClickListener(this)
//        signUpBtn.setOnClickListener {
//            Toast.makeText(this, "Sign Up Clicked", Toast.LENGTH_LONG).show()
//        }
    }

    var clickedOnce = false
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                Toast.makeText(this, "Login Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.btn_signup -> {

                if (clickedOnce) {
                    finish()
                } else {
                    // timer
                    clickedOnce = true
                    // on end of timer
                    clickedOnce = false
                }
                val intent = Intent(this, SignUpActivity::class.java)
                val bundle = Bundle()
                bundle.putString(EXTRA_NAME_KEY, email?.text.toString())
                intent.putExtras(bundle)
                // Flag to clear all activities on back stack
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                intent.putExtra("asd","asd")
//                startActivity(intent)
                startActivityForResult(intent, SIGNUP_REQUEST_ID)
//                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SIGNUP_REQUEST_ID) {
            if (resultCode == SIGNUP_DATA_RESULT_CODE) {
                val newName = data?.extras?.get(NEW_NAME).toString()
                Toast.makeText(this, newName, Toast.LENGTH_LONG).show()
            }
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }

    override fun doOperations(id: Int) {

    }
}

class A {

    var c: C? = null
    fun setInterfaceC(c: C) {
        this.c = c
    }

    var name: String = ""
    fun setNewName(newName: String) {
        name = newName
    }

    fun execute() {
        c?.doOperations(5)
    }
}

interface C {
    fun doOperations(id: Int)
}