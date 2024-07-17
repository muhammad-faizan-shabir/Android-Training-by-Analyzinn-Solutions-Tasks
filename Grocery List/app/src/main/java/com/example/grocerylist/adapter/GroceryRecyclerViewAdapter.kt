package com.example.grocerylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerylist.R
import com.example.grocerylist.model.GroceryModel

class GroceryRecyclerViewAdapter(private val mList: List<GroceryModel>): RecyclerView.Adapter<GroceryRecyclerViewAdapter.ViewHolder>()
{
    class ViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val textView1:TextView=this.itemView.findViewById(R.id.textview1)
        val textView2:TextView=this.itemView.findViewById(R.id.textview2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val groceryModel= mList[position]

        holder.textView1.text= groceryModel.itemName
        holder.textView2.text=groceryModel.quantity
    }


}