package com.evapharma.hackathon.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPersonDao(): PersonDAO


}