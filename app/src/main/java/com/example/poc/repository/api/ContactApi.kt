package com.example.poc.repository.api

import com.example.poc.model.Contact
import retrofit2.Response
import retrofit2.http.GET

fun interface ContactApi {
    @GET("api/users/random_user")
    suspend fun getContact(): Response<Contact>
}