package com.example.jalgasplan.utils

import com.example.jalgasplan.MainActivity
import com.example.jalgasplan.repository.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var AUTH:FirebaseAuth

lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var CURRENT_ID:String
const val ID_FIREBASE = "idFirebase"
const val ID_NAME = "id_name"
const val NAME = "name"
const val ADDRESS_NAME = "address_name"
lateinit var APP_Activity:MainActivity
lateinit var REPOSITORY: Repository