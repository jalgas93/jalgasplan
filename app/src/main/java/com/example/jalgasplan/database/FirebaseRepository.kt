package com.example.jalgasplan.database

import android.media.midi.MidiOutputPort
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository : Repository {


    private lateinit var database: FirebaseFirestore
    init {
        AUTH = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
    }




    override suspend fun insert(model: Model,id:String) {
        val document = database.collection(id).document()
        model.idFirebase = document.id
        val set = document.set(model)
        set.addOnSuccessListener { documentReference ->
            Log.d("jalgas", "DocumentSnapshot added with ID: ")
        }
            .addOnFailureListener { e ->
                Log.w("jalgas", "Error adding document", e)
            }


    }


    override suspend fun delete(model: Model, onSuccess: () -> Unit) {
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {

        AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess }
            .addOnFailureListener {
                onFail
                AUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }

        CURRENT_ID = AUTH.currentUser?.uid.toString()
        //REF_DATABASE = FirebaseDatabase.getInstance().reference
        // .child(CURRENT_ID)
    }

    override fun signOut() {
        AUTH.signOut()
    }

    override suspend fun insertContact(mainContactModel: Main_contact_model, id: String) {
        val document = database.collection(id).document()
        mainContactModel.idContact_firebase = document.id
        val set = document.set(mainContactModel)
        set.addOnSuccessListener { documnetReference->
            Log.i("jalgas10","addMainContact")
        }
            .addOnFailureListener {e->
                Log.i("jalgas10","ошибка addMainContact")


            }
    }


}