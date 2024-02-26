package com.example.fetchingdetails.repository.roomDatabase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.poc.model.Contact
import com.example.poc.repository.roomDatabase.ContactDao
import kotlinx.coroutines.flow.Flow


@Database(entities = [Contact::class], version = 1)
abstract class ContactRoomDatabase : RoomDatabase() {

    fun printDatabasePath(context: Context) {
        val dbPath: String = context.getDatabasePath("contact_DB").absolutePath
        Log.d("Database Path", dbPath)
    }

    abstract fun contactDao(): ContactDao
    fun getContacts(): Flow<List<Contact>> {
        return contactDao().getContact()
    }

    suspend fun addContact(contact: Contact) {
        contactDao().addContact(contact)
    }

    suspend fun removeContact(contact: Contact) {
        contactDao().removeContact(contact)
    }

    companion object {
        @Volatile
        private var instance: ContactRoomDatabase? = null
        fun getInstance(context: Context): ContactRoomDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, ContactRoomDatabase::class.java, "contactDB")
                            .build()
                }
            }
            return instance!!
        }

    }
}