package com.example.activitiesandfragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var container1: FrameLayout
    private lateinit var container2: FrameLayout
    private var container1Visibility=1
    private var container2Visibility=1
    private lateinit var fragment1: Fragment
    private lateinit var fragment2: Fragment



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
        setListeners()
    }

    private fun initUI()
    {
        button1= findViewById(R.id.button1)
        button2= findViewById(R.id.button2)

        container1= findViewById(R.id.fragment_container1)
        container2= findViewById(R.id.fragment_container2)

        fragment1= Fragment1()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container1, fragment1)
            .commit()

        fragment2= Fragment2()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container2, fragment2)
            .commit()
    }

    private fun setListeners()
    {
        button1.setOnClickListener()
        {
            if(container1Visibility==1)
            {
                container1Visibility=0
                container1.visibility= View.INVISIBLE
            }
            else
            {
                container1Visibility=1
                container1.visibility= View.VISIBLE
            }
        }

        button2.setOnClickListener()
        {
            if(container2Visibility==1)
            {
                container2Visibility=0
                container2.visibility= View.INVISIBLE
            }
            else
            {
                container2Visibility=1
                container2.visibility= View.VISIBLE
            }
        }
    }
}