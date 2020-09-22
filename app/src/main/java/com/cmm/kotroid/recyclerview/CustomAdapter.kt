package com.cmm.kotroid.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cmm.kotroid.R
import com.cmm.kotroid.database.MySecondObject

class CustomAdapter (private val context : Context) : RecyclerView.Adapter<CustomAdapter.MyCustomViewHolder>() {

    private val myData : ArrayList<MySecondObject> = ArrayList();
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(inflater.inflate(R.layout.item_custom_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentObjectDataSample = myData[position]

        holder.textViewTitle.text = currentObjectDataSample.title
        holder.textViewValue.text = currentObjectDataSample.value.toString()
    }

    override fun getItemCount(): Int {
        return myData.size;
    }

    fun rebuild(generateFakeData: ArrayList<MySecondObject>) {
        this.myData.clear()
        this.myData.addAll(generateFakeData)
        this.notifyDataSetChanged()
    }

    inner class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle : TextView = itemView.findViewById(R.id.TextViewTitle)
        val textViewValue : TextView = itemView.findViewById(R.id.TextViewValue)
    }
}