package com.evapharma.hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RVActivity : AppCompatActivity() {
    val users = mutableListOf<User>().apply {
        add(User(fName = "First Name 01", sName = "Second Name 01", email = "User01@users.com"))
        add(
            User(
                fName = "First Name 02",
                sName = "Second Name 02",
                email = "User02@users.com",
                isAdmin = true
            )
        )
        add(User(fName = "First Name 03", sName = "Second Name 03", email = "User03@users.com"))
        add(User(fName = "First Name 04", sName = "Second Name 04", email = "User04@users.com"))
        add(
            User(
                fName = "First Name 05",
                sName = "Second Name 05",
                email = "User05@users.com",
                isAdmin = true
            )
        )
        add(User(fName = "First Name 06", sName = "Second Name 06", email = "User06@users.com"))
        add(User(fName = "First Name 07", sName = "Second Name 07", email = "User07@users.com"))
        add(
            User(
                fName = "First Name 08",
                sName = "Second Name 08",
                email = "User08@users.com",
                isAdmin = true
            )
        )
    }

    val adapter = UsersAdapter(users)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.layoutManager = GridLayoutManager(this,2)
        recycler.adapter = adapter
//
//        object : Thread() {
//            override fun run() {
//                super.run()
//                sleep(10000)
//                runOnUiThread {
//                    adapter.updateData(users.reversed())
//                }
//            }
//        }.start()
    }
}