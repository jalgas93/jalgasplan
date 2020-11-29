package com.example.jalgasplan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Create a new user with a first and last name
//        val user: MutableMap<String, Any> = HashMap()
//        user["first"] = "Jalgas"
//        user["last"] = "Ungarbaev"
//        user["department"] = "GGE"


        // Add a new document with a generated ID

        // Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener { documentReference -> Log.d("jalgas", "DocumentSnapshot added with ID: " + documentReference.id) }
//                .addOnFailureListener { e -> Log.w("jalgasError", "Error adding document", e) }

        var navView: BottomNavigationView = findViewById(R.id.nav_bottom)
        val navController = Navigation.findNavController(this,R.id.fragmentContainer)
        navView.setupWithNavController(navController)


    }
}