package com.example.jalgasplan.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model

interface Repository {


    suspend fun insert(model: Model,id:String)
    suspend fun delete(model: Model, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit)

    fun signOut()
    suspend fun insertContact(mainMain_contact_model: Main_contact_model,id: String)



}