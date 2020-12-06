package com.example.jalgasplan.screens.appToMainContactFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMainContactViewModel(application: Application):AndroidViewModel(application) {

    fun insertAddMainContact(mainContactModel: Main_contact_model,id:String){
        viewModelScope.launch ( Dispatchers.IO ){
            REPOSITORY.insertContact(mainContactModel,id)
        }
    }
}