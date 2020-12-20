package com.example.jalgasplan.screens.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jalgasplan.repository.MainRepository
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.screens.contact_items.ContactViewModel
import com.example.jalgasplan.screens.generalFragment.GeneralFragmentViewModel


class ContactFactory(var repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContactViewModel(repository) as T
    }
}
