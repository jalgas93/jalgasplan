package com.example.jalgasplan.screens.generalFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.database.FirebaseRepository
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
    private lateinit var database: FirebaseFirestore
    var _allModels = MutableLiveData<ArrayList<Model>>()
    val allModels: MutableLiveData<ArrayList<Model>>
        get() = _allModels
    init {
        database = FirebaseFirestore.getInstance()
    }
      fun deleteItem(model: Model, id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(model, id)
        }
    }

    fun getData(id: String) {
        database.collection(id)
            .get()
            .addOnSuccessListener { result ->
                var model = ArrayList<Model>()
                for (document in result) {
                    Log.d("jalgas6", "${id.toString()} => ${document.data}")
                    model.add(
                        Model(
                            document.get("idFirebase") as String,
                            document.get("id_name") as String,
                            document.get("name") as String
                        )
                    )
                }
                Log.d("jalgas5", model.toString())

                _allModels.value = model
                var a = allModels.value
                Log.d("jalgas7", a.toString())
            }
            .addOnFailureListener { exception ->
                Log.d("jalgas", "Error getting documents: ", exception)
            }

    }


}



