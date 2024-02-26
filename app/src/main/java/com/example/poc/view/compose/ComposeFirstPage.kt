package com.example.poc.view.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.example.poc.viewModel.ContactViewModel

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ComposeFirstPage(contactViewModel: ContactViewModel) {
    val listState = rememberLazyListState()
    val list = contactViewModel.list.collectAsState()
    val cardModifier: Modifier = remember {
        Modifier
            .fillMaxSize()
            .padding(vertical = 3.dp)
    }
    val imageModifier: Modifier = remember {
        Modifier
            .size(80.dp)

    }
    val rowModifier: Modifier = remember {
        Modifier
            .padding(vertical = 35.dp)
    }
    val rowModifier1: Modifier = remember {
        Modifier.padding(horizontal = 10.dp)
    }
    val rowModifier2: Modifier = remember {
        Modifier.padding(10.dp)
    }
    val rowModifier3: Modifier = remember {
        Modifier
            .padding(vertical = 35.dp, horizontal = 40.dp)
    }



    LazyColumn(
        state = listState,
        modifier = Modifier
            .semantics { testTagsAsResourceId = true }
            .testTag("lazy-column")
    ) {
        itemsIndexed(list.value,
            key = { index, contact -> contact.hashCode() },
            contentType = { index, item -> index % 4 }
        ) { index,
            contact ->
            when (index % 4) {
                0 -> Layout1(
                    contact = contact,
                    imageModifier = imageModifier,
                    cardModifier = cardModifier,
                    rowModifier = rowModifier3
                )

                1 -> Layout2(
                    contact = contact,
                    imageModifier = imageModifier,
                    cardModifier = cardModifier,
                    rowModifier1 = rowModifier1,
                    rowModifier = rowModifier2
                )

                2 -> Layout3(
                    contact = contact,
                    imageModifier = imageModifier,
                    cardModifier = cardModifier,
                    rowModifier1 = rowModifier1,
                    rowModifier = rowModifier2
                )

                else -> Layout4(
                    contact = contact,
                    imageModifier = imageModifier,
                    cardModifier = cardModifier,
                    rowModifier = rowModifier
                )
            }
        }
    }
}
