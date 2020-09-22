package com.cmm.kotroid.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        MySecondObject::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun mySecondDao() : DAOMySecondObject
}
