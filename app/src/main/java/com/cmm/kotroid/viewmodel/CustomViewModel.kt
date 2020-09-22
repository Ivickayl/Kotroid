package com.cmm.kotroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmm.kotroid.database.MySecondObject
import com.cmm.kotroid.recyclerview.ObjectDataSample
import com.cmm.kotroid.repository.CustomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomViewModel : ViewModel() {

    private val repository: CustomRepository by lazy { CustomRepository() }

    var myDataMutableLiveData: LiveData<List<MySecondObject>> = repository.getDataFromDatabase()

    fun insertData(url : String, text: String, value: Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(MySecondObject(null, url, text, value))
        }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }

}