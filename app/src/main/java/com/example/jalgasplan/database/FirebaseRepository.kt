package com.example.jalgasplan.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.*

import com.example.jalgasplan.Room.BsDatabase
import com.example.jalgasplan.Room.UserDao

import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository(var context: Context) : Repository {


    private lateinit var database: FirebaseFirestore
    private lateinit var dao: UserDao




    init {
        database = FirebaseFirestore.getInstance()


    }


    override suspend fun insert(model: Model, id: String) {
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


    override suspend fun delete(model: Model, id: String) {
        database.collection(id).document(model.idFirebase)
            .delete()
            .addOnSuccessListener {
                Log.d(
                    "delete",
                    "DocumentSnapshot successfully deleted!${model.idFirebase}"
                )
            }

            .addOnFailureListener { e -> Log.w("delete", "Error deleting document", e) }
    }

    override suspend fun insertContact(mainContactModel: Main_contact_model, id: String) {
        val document = database.collection(id).document()
        mainContactModel.idContact_firebase = document.id
        val set = document.set(mainContactModel)
        set.addOnSuccessListener { documnetReference ->
            Log.i("jalgas/1", "addMainContact")
        }
            .addOnFailureListener { e ->
                Log.i("jalgas/2", "ошибка addMainContact")
            }
    }

    override suspend fun deleteContact(mainMain_contact_model: Main_contact_model, id: String) {

        database.collection(id).document(mainMain_contact_model.idContact_firebase)

            .delete()
            .addOnSuccessListener {
                Log.i(
                    "jalgas10",
                    "DocumentSnapshot successfully deleted!${mainMain_contact_model.idContact_firebase}"
                )
            }
            .addOnFailureListener { e -> Log.i("jalgas10", "Error deleting document", e) }
    }

   var daow = BsDatabase.getInstance(context).getDao()


    override suspend fun roomDelete(contact: Contact) {
        var dao = BsDatabase.getInstance(context).getDao()
        dao.deleteData(contact)
    }

//    override suspend fun data(contact: List<Contact>) {
//        daow.getAllContact()
//    }

    override suspend fun roomInsert(contact: Contact) {
        var dao = BsDatabase.getInstance(context).getDao()
        dao.insertData(contact)

    }

//    override var bs_liveData: MutableLiveData<List<Contact>>
//        get() = daow.getAllContact()
//        set(value) {}
}






