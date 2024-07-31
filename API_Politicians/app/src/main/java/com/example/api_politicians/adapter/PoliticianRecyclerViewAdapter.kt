package com.example.api_politicians.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.api_politicians.R
import com.example.api_politicians.data.model.Politician
import com.example.api_politicians.repository.PoliticianRepository
import kotlinx.coroutines.withContext

class PoliticianRecyclerViewAdapter(private val mList: List<Politician>): RecyclerView.Adapter<PoliticianRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView= this.itemView.findViewById(R.id.imageview1)
        val textView1: TextView =this.itemView.findViewById(R.id.textview1)
        val textView2: TextView =this.itemView.findViewById(R.id.textview2)
        val textView3: TextView =this.itemView.findViewById(R.id.textview3)
        val textView4: TextView =this.itemView.findViewById(R.id.textview4)
        val textView5: TextView =this.itemView.findViewById(R.id.textview5)
        val textView6: TextView =this.itemView.findViewById(R.id.textview6)
        val textView7: TextView =this.itemView.findViewById(R.id.textview7)
        //val textView8: TextView =this.itemView.findViewById(R.id.textview8)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val politicianModel= mList[position]

        Glide.with(holder.imageView.context).load(politicianModel.image).into(holder.imageView)
        holder.textView1.text= "ID: "+politicianModel.id.toString()
        holder.textView2.text= "Name: "+politicianModel.name
        holder.textView3.text= "DOB: "+politicianModel.dob
        holder.textView4.text= "Country: "+politicianModel.country
        holder.textView5.text= "Party: "+politicianModel.party
        holder.textView6.text= "Position: "+politicianModel.position
        holder.textView7.text= "Years in Office: "+politicianModel.years_in_office
        //holder.textView8.text= "Biography: \n"+politicianModel.biography
    }
}