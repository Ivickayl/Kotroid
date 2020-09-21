package com.cmm.kotroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cmm.kotroid.recyclerview.RecyclerViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchRecyclerView(view: View){
        val intent = Intent(this, RecyclerViewActivity::class.java)

        startActivity(intent)
    }

    fun launchSecondActivity(view: View) {
        val intentKotlin = Intent(this, SecondActivity::class.java).also {
            it.putExtras(Bundle().apply {
                putString("TEXTVIEW-CONTENT", "Kotroid from Second Activity")
            })
        }

        startActivity(intentKotlin)
    }
}