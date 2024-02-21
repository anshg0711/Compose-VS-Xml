package com.example.poc.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.poc.model.Contact
import com.example.poc.repository.api.ContactApi
import com.example.poc.repository.api.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContactViewModel(private val contactRoomDatabase: ContactRoomDatabase) : ViewModel() {
    private var _list = MutableStateFlow<List<Contact>>(mutableListOf())

    private val contactApi = RetrofitHelper.getInstance().create(ContactApi::class.java)

    val list: StateFlow<List<Contact>>
        get() = _list

    private fun fetchContacts() {

        if (_list.value.size < 1000)
            viewModelScope.launch(Dispatchers.IO) {

                while (_list.value.size < 1000) {
                    Log.d("Calling fetch function", "Calling fetch")
                    println("fetching ${Thread.currentThread().name}")
                    val contact = contactApi.getContact().body()!!
//                    _list.value=_list.value+contact
                    contactRoomDatabase.addContact(contact)
                }
            }
//        val mutableMap= mutableMapOf<Int, Int>()
//        var flag=false
//        for(contact in list.value){
//            if(mutableMap.contains(contact.id)){
//                viewModelScope.launch {
//                contactRoomDatabase.removeContact(contact)}
//                flag=true
//            }
//            mutableMap.put(contact.id, 1)
//
//        }
//        mutableMap.clear()
//        if(flag)
//            fetchContacts()

    }

    private fun getContacts() {
        viewModelScope.launch {
            fetchContacts()
            contactRoomDatabase.getContacts()
                .collectLatest { list ->
                    _list.value=list
                }

        }
    }

    init {
        getContacts()
    }

}