package com.example.poc.view.compose

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.poc.model.Contact

@Composable
fun Layout3(contact: Contact, @SuppressLint("ModifierParameter") cardModifier: Modifier, imageModifier: Modifier, rowModifier: Modifier, rowModifier1: Modifier ) {





    Card(
        modifier = cardModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {

        Row(rowModifier) {

            Column(Modifier.weight(.7F)) {
                Row(rowModifier1) {
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

                Row(rowModifier1) {
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
                modifier = imageModifier
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
                    Log.d("qwert", "${Thread.currentThread().name}")
                }
            )

        }
    }
}