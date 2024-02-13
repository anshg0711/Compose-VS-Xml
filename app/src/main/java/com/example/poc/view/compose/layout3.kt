package com.example.poc.view.compose

import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.poc.model.Contact

@Composable
fun Layout3(contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {

        Row(Modifier.padding(10.dp)) {


            Column(Modifier.weight(.7F)) {
                Row(Modifier.padding(horizontal = 10.dp)) {
                    Text(

                        fontSize = 20.sp,
                        fontWeight = FontWeight(1000),
                        text = "FirstName: "
                    )

                    Text(
                        fontSize = 20.sp,
                        text = "${contact.first_name}  "
                    )
                }

                Row(Modifier.padding(horizontal = 10.dp)) {
                    Text(

                        fontSize = 20.sp,
                        fontWeight = FontWeight(1000),
                        text = "LastName: "
                    )
                    Text(
                        fontSize = 20.sp,
                        text = "${contact.last_name}  "
                    )
                }

            }
            AndroidView(
                modifier = Modifier
                    .size(80.dp)
                    .weight(.3F),
                factory = { context ->
                    ImageView(context).apply {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }
                },
                update = { imageView ->
                    Glide.with(imageView)
                        .load(contact.avatar)
                        .into(imageView)
                }
            )

        }
    }
}