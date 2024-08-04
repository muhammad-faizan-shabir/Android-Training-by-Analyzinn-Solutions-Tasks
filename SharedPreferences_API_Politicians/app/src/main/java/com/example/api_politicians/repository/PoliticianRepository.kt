package com.example.api_politicians.repository

import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.data.network.ApiService
import com.example.api_politicians.data.network.PoliticianAPIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PoliticianRepository {
    private val apiService: ApiService = PoliticianAPIClient.instance

    fun getPoliticians(onResult: (List<Politician>?) -> Unit, onError: (Throwable) -> Unit) {
        val call = apiService.getPoliticians()

        call.enqueue(object : Callback<List<Politician>> {
            override fun onResponse(call: Call<List<Politician>>, response: Response<List<Politician>>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onError(Throwable(response.errorBody()?.string()))
                }
            }

            override fun onFailure(call: Call<List<Politician>>, t: Throwable) {
                onError(t)
            }

        })
    }
}