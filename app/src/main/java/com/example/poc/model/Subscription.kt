package com.example.poc.model

import androidx.compose.runtime.Immutable

@Immutable
data class Subscription(
    val payment_method: String,
    val plan: String,
    val status: String,
    val term: String
)