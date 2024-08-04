package com.example.api_politicians.data.network

import com.example.api_politicians.data.model.Politician
import retrofit2.Call
import retrofit2.http.GET

interface ApiService
{
    @GET("politicians")
    fun getPoliticians(): Call<List<Politician>>

    // ALL METHOD SHOULD BE MENTIONED HERE
    // PUT
    // POST
    // GET
}