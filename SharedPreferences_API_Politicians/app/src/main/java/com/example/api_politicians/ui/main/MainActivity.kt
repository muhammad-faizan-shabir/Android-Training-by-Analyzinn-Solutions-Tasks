package com.example.api_politicians.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_politicians.R
import com.example.api_politicians.adapter.PoliticianRecyclerViewAdapter
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.preferences.PreferenceManager
import com.example.api_politicians.repository.PoliticianRepository
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private val politicianRepository = PoliticianRepository()
    private lateinit var politicianRecyclerViewAdapter: PoliticianRecyclerViewAdapter
    private lateinit var politicianRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        politicianRecyclerView= findViewById(R.id.recyclerView)
        politicianRecyclerView.layoutManager=LinearLayoutManager(this)
        fetchPoliticians()
    }

    private fun fetchPoliticians() {
        // Check if student data is already saved in SharedPreferences
        val savedPoliticiansJson = PreferenceManager.get("politicians", "")
        if (!savedPoliticiansJson.isNullOrEmpty()) {
            val toast = Toast.makeText(applicationContext, "Data Fetched Locally", Toast.LENGTH_LONG).show()

            // Parse saved student data and log it
            val politicians: List<Politician> = deserializePoliticians(savedPoliticiansJson)
            val listForAdapter: List<Politician> = politicians ?: emptyList()
            politicianRecyclerViewAdapter= PoliticianRecyclerViewAdapter(listForAdapter)
            politicianRecyclerView.adapter= politicianRecyclerViewAdapter
            politicians.forEach { politician ->
                Log.d("MainActivity", "Politician ${politician.name}, Country: ${politician.country}, Position: ${politician.position}")
            }
        } else {
            val toast = Toast.makeText(applicationContext, "Data Fetched from API", Toast.LENGTH_LONG).show()
            // Fetch student data from repository (API call)
            politicianRepository.getPoliticians(
                onResult = { politicians ->
                    val listForAdapter: List<Politician> = politicians ?: emptyList()
                    politicianRecyclerViewAdapter= PoliticianRecyclerViewAdapter(listForAdapter)
                    politicianRecyclerView.adapter= politicianRecyclerViewAdapter
                    politicians?.forEach { politician ->
                        Log.d("MainActivity", "Politician ${politician.name}, Country: ${politician.country}, Position: ${politician.position}")
                    }
                    // Save the fetched student data in SharedPreferences
                    val politiciansJson = serializePoliticians(politicians)
                    PreferenceManager.save("politicians", politiciansJson)
                },
                onError = { error ->
                    Log.e("MainActivity", "Error: ${error.message}")
                }
            )
        }
    }

    private fun serializePoliticians(politicians: List<Politician>?): String {
        // Serialize the list of students to JSON
        return PreferenceManager.gson.toJson(politicians)
    }

    private fun deserializePoliticians(data: String): List<Politician> {
        // Deserialize the JSON string to a list of students
        return PreferenceManager.gson.fromJson(data, object : TypeToken<List<Politician>>() {}.type)
    }
}