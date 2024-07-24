package com.example.activitiesandfragments

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private var item1: String?= ""
    private var item2: String?= ""
    private lateinit var textview1: TextView
    private lateinit var textview2: TextView
    private lateinit var productDetailTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()
    }

    private fun initUI()
    {
        item1= intent.getStringExtra("item1")
        item2= intent.getStringExtra("item2")
        textview1=findViewById(R.id.textview1)
        textview2=findViewById(R.id.textview2)
        productDetailTextView = findViewById(R.id.productDetailTextView)
        imageView = findViewById(R.id.imageViewProduct)
        textview1.text= "Item1: "+item1
        textview2.text="Item2: "+item2
        val product = intent.getStringExtra("product")
        val imageResId = intent.getIntExtra("productImage", -1)
        imageView.setImageResource(imageResId)
        productDetailTextView.text = product
    }
}