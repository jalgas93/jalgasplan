package com.example.jalgasplan.screens.generalFragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class GeneralFactory() :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GeneralFragmentViewModel() as T
    }
}