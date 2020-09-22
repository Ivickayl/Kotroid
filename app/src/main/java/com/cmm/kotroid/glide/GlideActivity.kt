package com.cmm.kotroid.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.cmm.kotroid.R
import com.cmm.kotroid.glide.CustomGlideAdapter
import com.cmm.kotroid.recyclerview.ObjectDataSample
import kotlinx.android.synthetic.main.activity_glide.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class GlideActivity : AppCompatActivity() {

    private lateinit var adapter: CustomGlideAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        adapter = CustomGlideAdapter(this)
        glideRecyclerView.layoutManager =
            GridLayoutManager(this, resources.getInteger(R.integer.number_of_columns))
        glideRecyclerView.adapter = adapter

        adapter.rebuild(generateFakeData())
    }

    private fun generateFakeData(): ArrayList<GlideDataSample> {
        return arrayListOf(
            GlideDataSample(
                "https://upload.wikimedia.org/wikipedia/fr/7/71/Chrono_Trigger_%28JAP%29_Logo.png",
                "Chrono Trigger"
            ),
            GlideDataSample(
                "https://upload.wikimedia.org/wikipedia/fr/e/ec/Metal_Gear_Solid_3_Snake_Eater_Logo.png",
                "MGS3:Snake Eater"
            ),
            GlideDataSample(
                "https://upload.wikimedia.org/wikipedia/fr/1/11/Tales_of_Symphonia_Logo.jpg",
                "Tales Of Symphonia"
            )
        )
    }
}