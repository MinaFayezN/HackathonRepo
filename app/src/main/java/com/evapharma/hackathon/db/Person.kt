package com.evapharma.hackathon.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    val id: Int,
    @ColumnInfo(name = "person_name")
    val name: String,
    @ColumnInfo(name = "person_email")
    val email: String
)