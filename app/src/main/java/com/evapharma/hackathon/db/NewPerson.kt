package com.evapharma.hackathon.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "new_person_table")
data class NewPerson(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    val id: Int,
    @ColumnInfo(name = "person_name")
    val name: String,
    @ColumnInfo(name = "person_email")
    val email: String
)