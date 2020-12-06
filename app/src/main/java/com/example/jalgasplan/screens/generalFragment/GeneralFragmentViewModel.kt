package com.example.jalgasplan.screens.generalFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.REPOSITORY
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneralFragmentViewModel() : ViewModel() {

    val allModels:MutableLiveData<ArrayList<Model>> = MutableLiveData()
        private lateinit var database: FirebaseFirestore
        init {
            database = FirebaseFirestore.getInstance()
        }
    fun signOut() {
        REPOSITORY.signOut()
    }

    fun getData(id:String) {

        database.collection(id)
            .get()
            .addOnSuccessListener { result ->
                var model = ArrayList<Model>()
                for (document in result) {
                    Log.d("jalgas", "${id.toString()} => ${document.data}")
                   model.add(

                       Model(
                       document.get("id_name")as String,
                           document.get("name") as String,
                           document.get("address_name")as String
                   )
                   )


                }
                allModels.value = model
            }

            .addOnFailureListener { exception ->
                Log.d("jalgas", "Error getting documents: ", exception)
            }
    }
    }


