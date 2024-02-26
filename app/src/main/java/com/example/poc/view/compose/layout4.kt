package com.example.poc.view.compose

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.poc.model.Contact
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Layout4(contact: Contact, @SuppressLint("ModifierParameter") cardModifier: Modifier, imageModifier: Modifier, rowModifier: Modifier ) {
    val avatarUrl = remember(contact.id) { contact.avatar }
    Card(
        modifier = cardModifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {

        Row {
//            AndroidView(
//                modifier = imageModifier
//                    .weight(.3F),
//                factory = { context ->
//                    ImageView(context).apply {
//                        scaleType = ImageView.ScaleType.FIT_END
//                    }
//                },
//                update = { imageView ->
//                    CoroutineScope(Dispatchers.Main).launch {
//                        val bitmap = withContext(Dispatchers.IO) {
//                            Glide.with(imageView)
//                                .asBitmap()
//                                .load(contact.avatar)
//                                .submit()
//                                .get()
//                        }
//                        imageView.setImageBitmap(bitmap)
//                    }
//                }
//            )
            GlideImage(
                imageModel = avatarUrl,
                modifier = imageModifier.weight(.3F)
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = rowModifier
                    .weight(.7F),
                fontSize = 20.sp,
                text = "${contact.first_name} ${contact.last_name}"
            )

        }

    }


}


