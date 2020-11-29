package com.example.jalgasplan.utils

import android.widget.Toast

fun showToast(message:String){
    Toast.makeText(APP_Activity,message,Toast.LENGTH_SHORT).show()
}