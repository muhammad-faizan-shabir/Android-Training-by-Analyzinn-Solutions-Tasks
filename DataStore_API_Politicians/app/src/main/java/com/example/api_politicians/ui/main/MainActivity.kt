package com.example.api_politicians.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_politicians.R
import com.example.api_politicians.adapter.PoliticianRecyclerViewAdapter
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.viewmodel.PoliticianViewModel

class MainActivity : AppCompatActivity() {
    private val politicianViewModel: PoliticianViewModel by viewModels()
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

        politicianViewModel.politicians.observe(this) { politicians ->

            val listForAdapter: List<Politician> = politicians ?: emptyList()
            politicianRecyclerViewAdapter= PoliticianRecyclerViewAdapter(listForAdapter)
            politicianRecyclerView.adapter= politicianRecyclerViewAdapter

            politicians?.forEach { politician ->
                Log.d(
                    "MainActivity",
                    "Politician: ${politician.name}, Country: ${politician.country}, Position: ${politician.position}"
                )
            }

            Toast.makeText(applicationContext, "Called", Toast.LENGTH_LONG).show()
            Log.d(
                "MainActivity",
                "size: ${politicians.size}"
            )

        }

        politicianViewModel.error.observe(this) { error ->
            Log.e("MainActivity", "Error: $error")
        }
    }
}