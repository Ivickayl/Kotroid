package com.cmm.kotroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAOMySecondObject {

    @Query("SELECT * FROM my_pojo_table")
    fun selectAll(): LiveData<List<MySecondObject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(myData: List<MySecondObject>): List<Long>

    @Insert()
    fun insert(myData: MySecondObject)

    @Query("DELETE FROM my_pojo_table")
    fun deleteAll()
}