package com.example.jalgasplan.database

import androidx.lifecycle.LiveData
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository : Repository {
    init {
        AUTH = FirebaseAuth.getInstance()
    }


    override val allModels: LiveData<List<Model>>
        get() = AllModelsLiveData()

    override suspend fun insert(model: Model, onSuccess: () -> Unit) {
        val idModel = REF_DATABASE.push().key.toString()
        val mapNote = hashMapOf<String, Any>()
        mapNote[ID_FIREBASE] = idModel
        mapNote[NAME] = model.username
        mapNote[TEXT] = model.lastname

        REF_DATABASE.child(idModel)
            .updateChildren(mapNote)
            .addOnSuccessListener { onSuccess }
            .addOnFailureListener { showToast(it.message.toString()) }
    }

    override suspend fun delete(model: Model, onSuccess: () -> Unit) {
        REF_DATABASE.child(model.idFirebase).removeValue()
            .addOnFailureListener { showToast(it.message.toString()) }
            .addOnSuccessListener { onSuccess }
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
        REF_DATABASE = FirebaseDatabase.getInstance().reference
            .child(CURRENT_ID)
    }

    override fun signOut() {
        AUTH.signOut()
    }


}