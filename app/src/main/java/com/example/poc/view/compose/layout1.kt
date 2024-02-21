package com.example.poc.view.compose

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.poc.model.Contact


@Composable

fun Layout1(contact: Contact, @SuppressLint("ModifierParameter") cardModifier: Modifier, imageModifier: Modifier, rowModifier: Modifier ) {

    val colour=CardDefaults.cardColors(containerColor = Color.White)

    Card(
        modifier = cardModifier,
        colors = colour,
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Row {
            Text(

                modifier = rowModifier
                    .weight(.7F)
                    ,
                fontSize = 20.sp,
                text = "${contact.first_name} ${contact.last_name}"
            )

            AndroidView(
                modifier = imageModifier
                    .weight(.3F),
                factory = { context ->
                    ImageView(context).apply {
                        scaleType = ImageView.ScaleType.FIT_END
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

