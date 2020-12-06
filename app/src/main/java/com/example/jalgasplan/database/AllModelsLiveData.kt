package com.example.jalgasplan.database

import androidx.lifecycle.LiveData
import com.example.jalgasplan.model.Model

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class AllModelsLiveData :LiveData<List<Model>>() {
  private var listener = object : ValueEventListener {
    override fun onCancelled(p0: DatabaseError) {

    }

    override fun onDataChange(p0: DataSnapshot) {
         value = p0.children.map {
           it.getValue(Model::class.java)?: Model()

         }
    }

  }

  override fun onInactive() {
//REF_DATABASE.removeEventListener(listener)
    super.onInactive()

  }

  override fun onActive() {
    //REF_DATABASE.addValueEventListener(listener)
    super.onActive()
  }
}