package com.example.jalgasplan.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jalgasplan.model.Contact

@Dao
interface UserDao {
    @Query("SELECT * FROM jalgas")
    fun getAllContact():LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertData(contact:Contact)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDataLive(contact:ArrayList<Contact>)


    @Delete
    suspend fun deleteData(contact: Contact)

    @Query("SELECT * FROM jalgas WHERE sideName LIKE :query")
    fun search(query:String):List<Contact>
}