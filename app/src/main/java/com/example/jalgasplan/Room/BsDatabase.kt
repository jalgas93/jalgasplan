package com.example.jalgasplan.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jalgasplan.model.Contact

@Database(entities = [Contact::class],version = 3)
abstract class BsDatabase:RoomDatabase() {
    abstract fun getDao():UserDao

    companion object{

        @Volatile
        private var database:BsDatabase?=null

        @Synchronized
        fun getInstance(context: Context):BsDatabase{
            return if (database==null){
                database = Room.databaseBuilder(
                    context,
                    BsDatabase::class.java,
                    "jalgas.db"


                )
                    .allowMainThreadQueries()
                    .createFromAsset("jalgas.db")
                    .build()

                database as BsDatabase
            } else database as BsDatabase
        }
    }

}