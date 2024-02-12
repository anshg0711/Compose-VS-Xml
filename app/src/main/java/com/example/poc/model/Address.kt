package com.example.poc.model

import androidx.room.Embedded

data class Address(
    val city: String,
    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val state: String,
    val street_address: String,
    val street_name: String,
    val zip_code: String
)