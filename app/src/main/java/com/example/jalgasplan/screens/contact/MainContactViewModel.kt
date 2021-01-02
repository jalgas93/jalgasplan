package com.example.jalgasplan.screens.contact

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.utils.REPOSITORY
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainContactViewModel : ViewModel() {
    private lateinit var database: FirebaseFirestore
    init {
        database = FirebaseFirestore.getInstance()
    }
    val contactLiveData: MutableLiveData<ArrayList<Main_contact_model>> = MutableLiveData()

    fun getContactData(sideName: String) {

        database.collection(sideName)
            .get()
            .addOnSuccessListener { result ->
                var model = ArrayList<Main_contact_model>()
                for (document in result) {
                    Log.i("jalgas/8", "${sideName}=>${document.data}")
                    model.add(
                        Main_contact_model(
                            document.get("idContact_firebase") as String,
                            document.get("name") as String,
                            document.get("phone") as String
                        )
                    )
                }
                Log.i("jalgas/9", model.toString())
                contactLiveData.value = model
                var a = contactLiveData.value
                Log.i("jalgas/7", a.toString())
            }
            .addOnFailureListener { exception ->
                Log.i("jalgas", "oshibka")
            }
    }
    fun main_ContactDelete(mainContactModel: Main_contact_model, id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteContact(mainContactModel, id)
        }
    }
}