package com.example.poc.repository.roomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.poc.model.Contact

@Dao
interface ContactDao {
    @Insert
    suspend fun addContact(contact: Contact)


    @Query("Select * from contact")
    suspend fun getContact(): List<Contact>

}