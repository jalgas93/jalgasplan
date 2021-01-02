package com.example.jalgasplan.screens.contact_items


import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.jalgasplan.Room.BsDatabase
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.repository.MainRepository

import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    var daow = BsDatabase.getInstance(application).getDao()
    var contactLiveData: MutableLiveData<List<Contact>> = MutableLiveData()
    lateinit var b: LiveData<List<Contact>>

    // var allModel = REPOSITORY.bs_liveData


    fun contacts() {

        viewModelScope.launch {
            var list = ArrayList<List<Contact>>()
           var c =   daow.getAllContact()
            list.add(c)
//            Log.i("arrayList", list.toString())
            contactLiveData.value = daow.getAllContact()

        }
    }

//    val user: LiveData<List<Contact>> = liveData {
//        val data = daow.getAllContact() // loadUser is a suspend function.
//        emit(data)
//    }

//    val userId: LiveData<List<Contact>> = MutableLiveData()
//    val user = userId.switchMap { id ->
//        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
//            emit(daow.getAllContact())
//        }
//
//    }
//val userId: LiveData<List<Contact>> = MutableLiveData()
//    fun data(): LiveData<List<Contact>> {
//    viewModelScope.launch {
//        REPOSITORY.bs_liveData
//    }
//    return  userId
//}


//    fun data():LiveData<List<Contact>>{
//        viewModelScope.launch(Dispatchers.IO){
//            REPOSITORY.bs_liveData
//
////        }
//        return liveData
//    }

//    fun insertDataLive(contact: ArrayList<Contact>) {
//        viewModelScope.launch(Dispatchers.IO) {
//            REPOSITORY.insertDataLiveData(contact)
//        }
//    }

    fun insertData(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.roomInsert(contact)
        }
    }

    fun deleteData(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.roomDelete(contact)
        }
    }


}





