package com.example.jalgasplan.screens.addData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddDataFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun insert(model: Model, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(model) {
                    onSuccess
            }
        }
}