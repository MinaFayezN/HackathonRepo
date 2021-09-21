package com.evapharma.hackathon.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDAO {
    @Query("Select * From PERSON_TABLE")
    fun getAllPersons(): List<Person>

    @Query("Select * From PERSON_TABLE Where person_name = :name")
    fun getPersonsByName(name: String): List<Person>

    @Insert
    fun insertPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)
}