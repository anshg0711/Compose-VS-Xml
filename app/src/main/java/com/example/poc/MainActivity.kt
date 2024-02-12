package com.example.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.poc.ui.theme.POCTheme
import com.example.poc.view.compose.ComposeFirstPage
import com.example.poc.viewModel.ContactViewModel
import com.example.poc.viewModel.ContactViewModelFactory


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val contactRoomDatabase: ContactRoomDatabase =
            ContactRoomDatabase.getInstance(this)
        val contactViewModel: ContactViewModel = ViewModelProvider(this, ContactViewModelFactory(contactRoomDatabase)).get(ContactViewModel::class.java)

        setContent {
            POCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeFirstPage(contactViewModel)
                }
            }
        }
    }
}
