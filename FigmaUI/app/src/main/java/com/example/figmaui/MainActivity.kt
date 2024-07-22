package com.example.figmaui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textview1: TextView
    private lateinit var textview2: TextView
    private lateinit var textview3: TextView
    private lateinit var textview4: TextView
    private lateinit var textview5: TextView
    private lateinit var textview6: TextView
    private lateinit var textview7: TextView
    private lateinit var textview8: TextView
    private lateinit var textview9: TextView
    private lateinit var edittext1: EditText
    private lateinit var edittext2: EditText
    private lateinit var textInputLayout: TextInputLayout
    private lateinit var appCompatButton1: AppCompatButton
    private lateinit var appCompatButton2: AppCompatButton
    private lateinit var view1: View
    private lateinit var view2: View
    private var visibility=1

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
        textview1=findViewById(R.id.textview1)
        textview2=findViewById(R.id.textview2)
        textview3=findViewById(R.id.textview3)
        textview4=findViewById(R.id.textview4)
        textview5=findViewById(R.id.textview5)
        textview6=findViewById(R.id.textview6)
        textview7=findViewById(R.id.textview7)
        textview8=findViewById(R.id.textview8)
        textview9=findViewById(R.id.textview9)
        edittext1=findViewById(R.id.edittext1)
        edittext2=findViewById(R.id.edittext2)
        textInputLayout=findViewById(R.id.Textinputlayout)
        appCompatButton1=findViewById(R.id.appCompatButton1)
        appCompatButton2=findViewById(R.id.appCompatButton2)
        view1=findViewById(R.id.view1)
        view2=findViewById(R.id.view2)
    }

    private fun setListeners()
    {
        textview9.setOnClickListener()
        {
            if(visibility==1)
            {
                visibility=0
                textview1.visibility= View.INVISIBLE
                textview2.visibility= View.INVISIBLE
                textview3.visibility= View.INVISIBLE
                textview4.visibility= View.INVISIBLE
                textview5.visibility= View.INVISIBLE
                textview6.visibility= View.INVISIBLE
                textview7.visibility= View.INVISIBLE
                textview8.visibility= View.INVISIBLE
                edittext1.visibility=View.INVISIBLE
                edittext2.visibility=View.INVISIBLE
                textInputLayout.visibility=View.INVISIBLE
                appCompatButton1.visibility=View.INVISIBLE
                appCompatButton2.visibility=View.INVISIBLE
                view1.visibility=View.INVISIBLE
                view2.visibility=View.INVISIBLE
            }
            else
            {
                visibility=1
                textview1.visibility= View.VISIBLE
                textview2.visibility= View.VISIBLE
                textview3.visibility= View.VISIBLE
                textview4.visibility= View.VISIBLE
                textview5.visibility= View.VISIBLE
                textview6.visibility= View.VISIBLE
                textview7.visibility= View.VISIBLE
                textview8.visibility= View.VISIBLE
                edittext1.visibility=View.VISIBLE
                edittext2.visibility=View.VISIBLE
                textInputLayout.visibility=View.VISIBLE
                appCompatButton1.visibility=View.VISIBLE
                appCompatButton2.visibility=View.VISIBLE
                view1.visibility=View.VISIBLE
                view2.visibility=View.VISIBLE
            }
        }
    }
}