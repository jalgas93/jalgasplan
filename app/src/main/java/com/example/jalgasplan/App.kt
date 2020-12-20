//package com.example.jalgasplan
//
//import android.app.Application
//import androidx.room.Room
//import com.example.jalgasplan.Room.BsDatabase
//
//class App:Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        instance = this
//
//        database = Room.databaseBuilder(this, BsDatabase::class.java, "bs_database")
//
//            .build()
//    }
//
//    companion object {
//        private var instance: App? = null
//        private var database: BsDatabase? = null
//
//        fun getInstance(): App {
//            return instance!!
//        }
//
//        fun getDatabase(): BsDatabase {
//            return database!!
//        }
//    }
//}