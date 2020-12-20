package com.example.jalgasplan.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model

interface Repository {
    suspend fun insert(model: Model,id:String)
    suspend fun delete(model: Model, id:String)
       suspend fun insertContact(mainMain_contact_model: Main_contact_model,id: String)
    suspend fun deleteContact(mainMain_contact_model: Main_contact_model,id: String)
    suspend fun roomInsert(contact:Contact)
        var bs_liveData:LiveData<List<Contact>>
    suspend fun roomDelete(contact:Contact)
    suspend fun insertDataLiveData(contact:ArrayList<Contact>)

   // var searchLiveData:LiveData<List<Contact>>




}