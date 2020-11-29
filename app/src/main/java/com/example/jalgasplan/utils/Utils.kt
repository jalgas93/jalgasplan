package com.example.jalgasplan.utils

import com.example.jalgasplan.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var AUTH:FirebaseAuth
lateinit var REF_DATABASE: DatabaseReference
lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var CURRENT_ID:String
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"
lateinit var APP_Activity:MainActivity