package com.evapharma.hackathon

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

private const val CALL_PERMISSION_CODE = 798
private const val CAMERA_REQUEST_CODE = 123

//implicit intent
class MainActivity : AppCompatActivity() {

    private lateinit var dialButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.iv_profile)
        dialButton = findViewById(R.id.btn_dial)
        dialButton.setOnClickListener {
            dial()
        }
        findViewById<Button>(R.id.btn_url).setOnClickListener {
            openURL()
        }
        findViewById<Button>(R.id.btn_call).setOnClickListener {
            // check Permission
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                call()
            } else {
                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_CODE)
            }
        }

        findViewById<Button>(R.id.btn_camera).setOnClickListener {
            openCamera()
        }
        // Libraries
        // https://mindorks.com/android/store
        // Resources
        // https://www.vogella.com/tutorials/android.html
        // https://www.tutorialspoint.com/android/index.htm

        // Plugin -> Kotlin fill class
        Person(name = null, address = "", email = "", phone = 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == CALL_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                call()
            else {
                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_CODE)
            }
        } else
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun dial() {
        val telephone = "tel:012313132132" // dialer/ caller Scheme
        val uri = Uri.parse(telephone)
        startActivity(Intent(Intent.ACTION_DIAL, uri))
    }

    private fun call() {
        val telephone = "tel:012313132132" // dialer/ caller Scheme
        val uri = Uri.parse(telephone)
        startActivity(Intent(Intent.ACTION_CALL, uri))
    }

    private fun openURL() {
        val url = "https://www.google.com" // dialer/ caller Scheme
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(Intent.createChooser(intent, "Please Select"))
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val bitmap = data?.extras?.get("data") as Bitmap
                if (::imageView.isInitialized)
                    imageView.setImageBitmap(bitmap)
            }
        } else
            super.onActivityResult(requestCode, resultCode, data)

    }
}

data class Person(
    val name: String?,
    val address: String,
    val email: String,
    val phone: Long,
)