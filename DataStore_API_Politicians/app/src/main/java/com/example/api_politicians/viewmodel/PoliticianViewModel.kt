package com.example.api_politicians.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.repository.PoliticianRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class PoliticianViewModel(application: Application) : AndroidViewModel(application) {
    private val politicianRepository = PoliticianRepository(application)
    private val _politicians = MutableLiveData<List<Politician>>()
    val politicians: LiveData<List<Politician>> get() = _politicians
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchPoliticians()
    }

    private fun fetchPoliticians() {
        viewModelScope.launch {
            try {
                // Fetch students using the repository
                val result = withContext(Dispatchers.IO) {
                    val politiciansList = mutableListOf<Politician>()
                    var fetchError: Throwable? = null

                    politicianRepository.getPoliticians(
                        onResult = { politicians ->


                            politiciansList.addAll(politicians ?: emptyList())
                            Log.d("viewmodel","politiciansList size: ${politiciansList.size}") },
                        onError = { error ->
                            fetchError = error
                        }
                    )

                    if (fetchError != null) {
                        throw fetchError!!
                    }



                    politiciansList
                }

                Thread.sleep(1500)

                Log.d("viewmodel","result size: ${result.size}")

                _politicians.postValue(result)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}