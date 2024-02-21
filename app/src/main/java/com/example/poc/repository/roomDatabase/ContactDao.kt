package com.example.poc.repository.roomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.poc.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    suspend fun addContact(contact: Contact)
    @Delete
    suspend fun removeContact(contact: Contact)

    @Query("Select * from contact")
    fun getContact(): Flow<List<Contact>>

}