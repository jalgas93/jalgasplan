package com.example.jalgasplan.utils

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.Room.BsDatabase
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class DataSource() {
//    companion object {
//        fun createDataSet(): List<List<Contact>>{
//            var daow = BsDatabase.getInstance(APP_Activity).getDao()
//            var list = ArrayList<List<Contact>>()
//
//
//            var s = daow.getAllContact()
//            list.add(s)
//
//            return list
//        }
//
//    }
//}