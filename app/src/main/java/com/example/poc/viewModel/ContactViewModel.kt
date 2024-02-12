package com.example.poc.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.poc.model.Contact
import com.example.poc.repository.api.ContactApi
import com.example.poc.repository.api.RetrofitHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactViewModel(private val contactRoomDatabase: ContactRoomDatabase) : ViewModel() {
    private var _list = MutableStateFlow<List<Contact>>(emptyList())
    private val contactApi = RetrofitHelper.getInstance().create(ContactApi::class.java)

    val list: StateFlow<List<Contact>>
        get() = _list

    private fun fetchContacts() {
        if (_list.value.size < 1000)
            viewModelScope.launch {

                while (_list.value.size < 1000) {
                    Log.d("Calling fetch function", "Calling fetch")
                    val contact = contactApi.getContact().body()!!
                    _list.value = _list.value + contactApi.getContact().body()!!
                    contactRoomDatabase.addContact(contact)
                }
            }
    }

    private fun getContacts() {
        viewModelScope.launch {
            val list: List<Contact> = contactRoomDatabase.getContacts()
            _list.value = list
            fetchContacts()
        }
    }

    init {
        getContacts()
    }

}