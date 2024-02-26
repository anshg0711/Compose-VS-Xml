package com.example.poc.view.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.poc.model.Contact
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Layout2(
    contact: Contact,
    @SuppressLint("ModifierParameter") cardModifier: Modifier,
    imageModifier: Modifier,
    rowModifier: Modifier,
    rowModifier1: Modifier
) {
    val avatarUrl = remember(contact.id) { contact.avatar }
    Card(
        modifier = cardModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Row(rowModifier) {
            GlideImage(
                imageModel = avatarUrl,
                modifier = imageModifier.weight(.3F),

                )

            Column(Modifier.weight(.5F)) {
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
        }
    }
}