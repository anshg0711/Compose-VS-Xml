package com.example.poc.view.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.poc.viewModel.ContactViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ComposeFirstPage(contactViewModel: ContactViewModel) {


    val list = contactViewModel.list.collectAsState()


//    val testContact = Contact(
//        address = Address(
//
//            city = "Test City",
//            coordinates = Coordinates(
//                lat = 123.456,
//                lng = 456.789
//            ),
//            country = "Test Country",
//            state = "Test State",
//            street_address = "123 Test Street",
//            street_name = "Test Street",
//            zip_code = "12345"
//        ),
//        avatar = "https://robohash.org/harumdistinctiodolore.png?size=300x300&set=set1",
//        credit_card = CreditCard(
//            cc_number = "1234 5678 9012 3456"
//        ),
//        date_of_birth = "2000-01-01",
//        email = "test@example.com",
//        employment = Employment(
//            key_skill = "Test Skill",
//            title = "Test Title"
//        ),
//        first_name = "Test",
//        gender = "Male",
//        id = 1,
//        last_name = "Contact",
//        password = "password",
//        phone_number = "123-456-7890",
//        social_insurance_number = "123-456-789",
//        subscription = Subscription(
//            payment_method = "Credit Card",
//            plan = "Premium",
//            status = "Active",
//            term = "Monthly"
//        ),
//        uid = "abcdef123456",
//        username = "testuser"
//    )


    LazyColumn {
        itemsIndexed(list.value,
            key = { index, contact -> contact.id }
        ) { index,
            contact ->
            var rem = index % 4
            if (rem == 0)
                Layout1(contact = contact)
            else if (rem == 1) Layout2(contact = contact)
            else if (rem == 2) Layout3(contact = contact)
            else Layout4(contact = contact)
        }
    }
}
