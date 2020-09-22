package com.cmm.kotroid.repository

import androidx.lifecycle.LiveData
import com.cmm.kotroid.database.MyApplication
import com.cmm.kotroid.database.MySecondObject
import com.cmm.kotroid.recyclerview.ObjectDataSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CustomRepository {

    private val dao = MyApplication.instance.applicationDatabase.mySecondDao()

    fun getDataFromDatabase(): LiveData<List<MySecondObject>> {
        return dao.selectAll()
    }

    suspend fun insert(myData: MySecondObject) = withContext(Dispatchers.IO) {
        dao.insert(myData)
    }

    fun deleteAllData() {
        dao.deleteAll()
    }
}