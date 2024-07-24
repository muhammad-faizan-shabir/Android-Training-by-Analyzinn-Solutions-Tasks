package com.example.activitiesandfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var button1:Button
    private lateinit var edittext1:EditText
    private lateinit var edittext2:EditText
    private lateinit var view:View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_2, container, false)
        initUI()
        setListeners()
        return view

    }

    private fun initUI()
    {
        button1= view.findViewById(R.id.button1)
        edittext1=view.findViewById(R.id.edittext1)
        edittext2=view.findViewById(R.id.edittext2)
    }

    private fun setListeners()
    {
        button1.setOnClickListener()
        {
            val intent = Intent(activity,MainActivity3::class.java)
            intent.putExtra("item1",edittext1.text.toString())
            intent.putExtra("item2",edittext2.text.toString())
            intent.putExtra("product", "Latest Smartphone")
            intent.putExtra("productImage", R.drawable.phone)
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}