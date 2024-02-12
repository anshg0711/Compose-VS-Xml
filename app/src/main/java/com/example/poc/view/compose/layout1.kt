package com.example.poc.view.compose

import android.util.Log
import androidx.compose.foundation.Image
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poc.model.Contact

@Composable
fun Layout1(contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {

        Row {
            Text(

                modifier = Modifier.weight(.7F).padding(vertical = 35.dp, horizontal = 40.dp),
                fontSize = 20.sp,

                text = "${contact.first_name} ${contact.last_name}"
            )

            Image(
                painter = rememberImagePainter(data = contact.avatar),
                contentDescription = "image of the avatar", modifier = Modifier.weight(.3F)
                    .size(80.dp)
                    .weight(.6F)
                    .clip(MaterialTheme.shapes.medium)
            )

        }
    }
}

