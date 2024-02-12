package com.example.poc.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.poc.model.Contact

class ContactViewModelFactory(private val contactRoomDatabase: ContactRoomDatabase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(contactRoomDatabase = contactRoomDatabase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}