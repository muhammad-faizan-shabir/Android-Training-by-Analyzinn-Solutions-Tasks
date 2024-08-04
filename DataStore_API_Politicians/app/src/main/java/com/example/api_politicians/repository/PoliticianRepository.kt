package com.example.api_politicians.repository

import android.content.Context
import android.util.Log
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.data.network.ApiService
import com.example.api_politicians.data.network.PoliticianAPIClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.api_politicians.preferences.DataStoreManager
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PoliticianRepository(private val context: Context) {

    private val apiService: ApiService = PoliticianAPIClient.instance
    private val politiciansKey = DataStoreManager.getStringKey("politicians")
    private val gson = Gson()

    fun getPoliticians(onResult: (List<Politician>?) -> Unit, onError: (Throwable) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            // First, try to fetch data locally
            val localData = fetchLocally()
            if (localData != null) {
                Log.d("repository","local data")

                onResult(localData)
            } else {

                // If no local data, fetch from API
                fetchPoliticiansFromApi(onResult, onError)
            }
        }
    }

    private fun fetchLocally(): List<Politician>? {
        val savedPoliticiansJson = DataStoreManager.getData(context, politiciansKey)
        return if (!savedPoliticiansJson.isNullOrEmpty()) {
            deserializePoliticians(savedPoliticiansJson)
        } else {
            null
        }
    }

    private fun fetchPoliticiansFromApi(onResult: (List<Politician>?) -> Unit, onError: (Throwable) -> Unit) {
        val call = apiService.getPoliticians()
        Log.d("repository","API data")

        call.enqueue(object : Callback<List<Politician>> {
            override fun onResponse(call: Call<List<Politician>>, response: Response<List<Politician>>) {
                if (response.isSuccessful) {
                    val politicians = response.body()
                    // Save the fetched student data in DataStore
                    CoroutineScope(Dispatchers.IO).launch {
                        val politiciansJson = serializePoliticians(politicians)
                        DataStoreManager.saveData(context, politiciansKey, politiciansJson)
                    }
                    onResult(politicians)
                } else {
                    onError(Throwable(response.errorBody()?.string()))
                }
            }

            override fun onFailure(call: Call<List<Politician>>, t: Throwable) {
                onError(t)
            }
        })
    }

    private fun serializePoliticians(politicians: List<Politician>?): String {
        // Serialize the list of students to JSON
        return gson.toJson(politicians)
    }

    private fun deserializePoliticians(data: String): List<Politician> {
        // Deserialize the JSON string to a list of students
        return gson.fromJson(data, object : TypeToken<List<Politician>>() {}.type)
    }
}