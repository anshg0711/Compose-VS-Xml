package com.example.poc.view.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.poc.model.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue



@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Layout4(contact: Contact) {
    var time: Int by rememberSaveable{ mutableStateOf(1) }
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {

        Row {
            Image(
                painter = rememberImagePainter(data = contact.avatar),
                contentDescription = "image of the avatar", modifier = Modifier
                    .weight(.3F)
                    .size(80.dp)
                    .weight(.6F)
                    .clip(MaterialTheme.shapes.medium)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(.7F)
                    .padding(vertical = 35.dp),
                fontSize = 20.sp,
                text = "${contact.first_name} ${contact.last_name}   ${time}"
            )
            CoroutineScope(Dispatchers.IO).launch {
                while (true){
                    delay(1000)
                    time=time+1
                }
            }

        }
    }



}


