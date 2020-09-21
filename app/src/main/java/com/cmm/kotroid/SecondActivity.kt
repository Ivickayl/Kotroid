package com.cmm.kotroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val valueFromIntent = intent?.extras?.getString("TEXTVIEW-CONTENT")
        textViewSecondActivity.text = valueFromIntent
    }
}