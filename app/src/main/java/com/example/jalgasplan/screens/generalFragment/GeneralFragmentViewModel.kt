package com.example.jalgasplan.screens.generalFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.REPOSITORY

class GeneralFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allModel = REPOSITORY.allModels
    fun signOut() {
        REPOSITORY.signOut()
    }
}