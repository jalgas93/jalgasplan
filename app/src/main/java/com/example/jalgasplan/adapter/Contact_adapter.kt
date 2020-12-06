package com.example.jalgasplan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Model
import kotlinx.android.synthetic.main.item_contact.view.*

class Contact_adapter : RecyclerView.Adapter<Contact_adapter.ContactViewHolder>() {

    var model: ArrayList<Contact> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sidename = itemView.rv_contact_sidename
        var number = itemView.rv_contact_number
        var name = itemView.rv_contact_name
        fun bind(contact: Contact) {
            sidename.text = contact.sideName
            number.text = contact.id.toString()
            name.text = contact.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }
    fun sumbitlist(list:ArrayList<Contact>){
        model = list
    }

    override fun getItemCount() =
        model.size


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(model[position])
    }
}