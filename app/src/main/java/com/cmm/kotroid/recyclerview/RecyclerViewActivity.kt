package com.cmm.kotroid.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmm.kotroid.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        adapter = CustomAdapter(this)
        gamesRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        gamesRecyclerView.adapter = adapter

        adapter.rebuild(generateFakeData())
    }

    private fun generateFakeData() : ArrayList<ObjectDataSample>{
        return arrayListOf(
            ObjectDataSample("Finfal Fantasy", 1997),
            ObjectDataSample("Pokemon Jaune", 1998),
            ObjectDataSample("Tales Of Symphonia", 2003),
            ObjectDataSample("Chrono Trigger", 1995),
            ObjectDataSample("Suikoden", 1995),
            ObjectDataSample("Legend Of Mana", 1999),
            ObjectDataSample("The Legend Of Dragoon", 1999)

        )
    }
}