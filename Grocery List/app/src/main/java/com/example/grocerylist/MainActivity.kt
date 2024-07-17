package com.example.grocerylist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerylist.adapter.GroceryRecyclerViewAdapter
import com.example.grocerylist.model.GroceryModel

class MainActivity : AppCompatActivity() {

    private val groceryList= ArrayList<GroceryModel>()
    private lateinit var groceryRecyclerViewAdapter: GroceryRecyclerViewAdapter
    private lateinit var groceryRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI()
    {
        groceryRecyclerView=findViewById(R.id.recyclerView)
        groceryRecyclerView.layoutManager=LinearLayoutManager(this)

        groceryList.add(GroceryModel("Eggs            ","1 dozen"))
        groceryList.add(GroceryModel("Cooking Oil","5 liters"))
        groceryList.add(GroceryModel("Mutton        ","2 KG"))
        groceryList.add(GroceryModel("Apples        ","6"))
        groceryList.add(GroceryModel("Milk            ","1 gallon"))

        for (i in 1..100)
        {
            groceryList.add(GroceryModel("BlahBlah    ","$i blah"))
        }

        groceryRecyclerViewAdapter= GroceryRecyclerViewAdapter(groceryList)
        groceryRecyclerView.adapter= groceryRecyclerViewAdapter


    }

}