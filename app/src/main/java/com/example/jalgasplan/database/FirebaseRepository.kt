package com.example.jalgasplan.database

import android.util.Log
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

    override suspend fun getData(model: Model, onSuccess: () -> Unit) {

    }


    override suspend fun insert(model: Model, onSuccess: () -> Unit) {
        val document = database.collection("jalgass").document()
        model.idFirebase = document.id
        val set = document.set(model)
        set.addOnSuccessListener { documentReference ->
            Log.d("jalgas", "DocumentSnapshot added with ID: ")
            onSuccess
        }
            .addOnFailureListener { e ->
                Log.w("jalgas", "Error adding document", e)
            }


    }


    override suspend fun delete(model: Model, onSuccess: () -> Unit) {
        //REF_DATABASE.child(model.idFirebase).removeValue()
        //   .addOnFailureListener { showToast(it.message.toString()) }
        // .addOnSuccessListener { onSuccess }
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


}