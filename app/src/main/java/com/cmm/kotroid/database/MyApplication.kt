package com.cmm.kotroid.database

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    ////////////////////////////////////////////
    // Attribute ///////////////////////////////
    ////////////////////////////////////////////

    companion object {
        lateinit var instance: MyApplication
    }

    ////////////////////////////////////////////
    // Managing Lifecycle //////////////////////
    ////////////////////////////////////////////

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val applicationDatabase: MyDatabase  by lazy {
        Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java,
            "MyBeautifulDatabase"
        ).fallbackToDestructiveMigration().build()
    }
}

