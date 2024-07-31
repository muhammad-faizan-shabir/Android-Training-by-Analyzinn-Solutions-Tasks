package com.example.api_politicians.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_politicians.R
import com.example.api_politicians.adapter.PoliticianRecyclerViewAdapter
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.repository.PoliticianRepository

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

    private fun fetchPoliticians()
    {
        politicianRepository.getPoliticians(
           onResult = { politicians ->
                val listForAdapter: List<Politician> = politicians ?: emptyList()
                politicianRecyclerViewAdapter= PoliticianRecyclerViewAdapter(listForAdapter)
                politicianRecyclerView.adapter= politicianRecyclerViewAdapter

                politicians?.forEach { politician ->
                    Log.d("MainActivity", "Politician: ${politician.name}, Country: ${politician.country}, position ${politician.position}")
                }
            },
            onError={ error ->
                Log.e("MainActivity", "Error: ${error.message}")
            }
        )
    }
}