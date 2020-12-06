package com.example.jalgasplan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Main_contact_model

class Main_contact_adapter:RecyclerView.Adapter<Main_contact_adapter.MainContactViewHolder>() {
    var main_contact:ArrayList<Main_contact_model> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }



    inner class MainContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(contact:Main_contact_model){}


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainContactViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_contact,parent,false)
        return MainContactViewHolder(view)
    }

    override fun getItemCount() = main_contact.size

    override fun onBindViewHolder(holder: MainContactViewHolder, position: Int) {

    }
}