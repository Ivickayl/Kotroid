package com.cmm.kotroid.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmm.kotroid.R
import com.cmm.kotroid.database.MySecondObject
import com.cmm.kotroid.viewmodel.CustomViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter
    private lateinit var viewModel: CustomViewModel
    private var observerMyData = Observer<List<MySecondObject>> {
        updateUi(ArrayList(it))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        adapter = CustomAdapter(this)
        //gamesRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        gamesRecyclerView.layoutManager =
            GridLayoutManager(this, resources.getInteger(R.integer.number_of_columns))
        gamesRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[CustomViewModel::class.java]

        //adapter.rebuild(generateFakeData())*/
    }

    override fun onStart() {
        super.onStart()
        viewModel.myDataMutableLiveData.observe(this, observerMyData)
    }

    override fun onStop() {
        viewModel.myDataMutableLiveData.removeObserver(observerMyData)
        super.onStop()
    }

    private fun updateUi(data: ArrayList<MySecondObject>) {
        adapter.rebuild(data)
    }

    fun addValue(view: View) {
        val random = Random.nextInt(0, 1000)
        viewModel.insertData("url - $random", "text - $random", random)
    }

    fun deleteAllDat(vew:View){
        viewModel.deleteAllData()
    }

}
