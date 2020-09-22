package com.cmm.kotroid.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_pojo_table")
data class MySecondObject(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    val url : String,
    val title : String,
    val value : Int
)
