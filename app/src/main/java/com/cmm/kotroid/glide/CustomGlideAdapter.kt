package com.cmm.kotroid.glide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cmm.kotroid.R
import com.cmm.kotroid.recyclerview.ObjectDataSample

class CustomGlideAdapter (private val context : Context) : RecyclerView.Adapter<CustomGlideAdapter.MyCustomViewHolder>() {

    private val myData : ArrayList<GlideDataSample> = ArrayList();
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(inflater.inflate(R.layout.item_custom_glide_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentObjectDataSample = myData[position]

        Glide.with(context)
            .load(currentObjectDataSample.url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView)

        holder.textView.text = currentObjectDataSample.value

    }

    override fun getItemCount(): Int {
        return myData.size;
    }

    fun rebuild(generateFakeData: ArrayList<GlideDataSample>) {
        this.myData.clear()
        this.myData.addAll(generateFakeData)
    }

    inner class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.glideImageView)
        val textView : TextView = itemView.findViewById(R.id.glideTextView)
    }
}