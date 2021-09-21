package com.evapharma.hackathon

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.evapharma.hackathon.db.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_write).setOnClickListener {
            val MIGRATION_1_2 = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL(
                        "CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                                "PRIMARY KEY(`id`))"
                    )
                }
            }

            val MIGRATION_2_3 = object : Migration(2, 3) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Book ADD COLUMN pub_year INTEGER")
                }
            }

            val appDb: AppDatabase =
                Room.databaseBuilder(
                    this,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
            appDb.getPersonDao()

            val db = MyDB(this@MainActivity)
            val result = db.addUser("Mina", "M@M.com")
            val text = if (result) " Added Successfully " else " Error Adding"
            Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn_read).setOnClickListener {
            val db = MyDB(this@MainActivity)
//            db.updateUser()
            val result: String = db.getUsers().toString().ifEmpty { "No Data" }
            Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
        }
    }

    private fun readFromSharedPref() {
        val sharedPref = getSharedPreferences("AppSettings", MODE_PRIVATE)
        val name = sharedPref.getString("Name", "No name found")
        Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT).show()
    }

    private fun writeToSharedPref() {
        val sharedPref = getSharedPreferences("AppSettings01", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("Name", "Mina")
        editor.putBoolean("LoggedIn", true)
        editor.apply()
    }
}