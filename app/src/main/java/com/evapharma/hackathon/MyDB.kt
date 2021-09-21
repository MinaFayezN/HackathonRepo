package com.evapharma.hackathon

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val DATABASE_NAME = "AppDataBaseName"
private const val DATABASE_VERSION = 1

class MyDB(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        // Creating database
        // Create Table USERS with phone
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,EMAIL TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // create tables
        if (oldVersion == 1) {
            val users = getUsers()
            //dropttable
            //onCreate
            //insertUsers

            // migrate data from old tables
            // select all ------------ cached data
            // drop table USERS
            // Create Table USERS with phone ( onCreate(db))
            // publish old data with migrated scheme
        }
    }


    // Functions that deals with the table as it has the phone column
    fun addUser(username: String, email: String): Boolean {
        val db = writableDatabase
        val contentValue = ContentValues()
        contentValue.put("USERNAME", username)
        contentValue.put("EMAIL", email)
        val id = db.insert("USERS", null, contentValue)
        db.close()
        return id != -1L
    }

    fun getUsers(): List<User> {
        val usersResult = mutableListOf<User>()
        val db = readableDatabase
        val cursor = db.query(
            "USERS",
            arrayOf("*"),//arrayOf("USERNAME","EMAIL"),
            "",//"ID = ? OR USERNAME == ?",
            arrayOf(),//arrayOf("$id", name),
            "",
            "",
            ""
        )
        if (cursor.moveToFirst()) {
            do {
                val usernameIndex = cursor.getColumnIndex("USERNAME")
                val emailIndex = cursor.getColumnIndex("EMAIL")
                usersResult.add(User(cursor.getString(usernameIndex), cursor.getString(emailIndex)))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return usersResult
    }

    fun updateUser() {
        val db = writableDatabase
        val contentValue = ContentValues()
        contentValue.put("USERNAME", "New Name")
        contentValue.put("EMAIL", "N@N.com")
        db.update("USERS", contentValue, "ID = ?", arrayOf("2"))
        db.close()
    }

}


data class User(val username: String, val email: String)