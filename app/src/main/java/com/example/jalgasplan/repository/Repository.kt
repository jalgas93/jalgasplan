package com.example.jalgasplan.repository

import androidx.lifecycle.LiveData
import com.example.jalgasplan.model.Model

interface Repository {
    suspend fun getData(model: Model,onSuccess: () -> Unit)
    suspend fun insert(model: Model, onSuccess: () -> Unit)
    suspend fun delete(model: Model, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit)

    fun signOut()


}