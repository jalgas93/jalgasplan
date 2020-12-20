package com.example.jalgasplan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model
import kotlinx.android.synthetic.main.item_contact.view.*

class Contact_adapter : RecyclerView.Adapter<Contact_adapter.ContactViewHolder>() {

    var model: List<Contact> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

   // var search: ArrayList<Contact> = arrayListOf()

//    fun search(list: List<Contact>) {
//        search.clear()
//        search.addAll(list)
//        filter("")
//        notifyDataSetChanged()
//        Log.i("jalgas",filter("").toString())
//
//    }

//     fun filter(query: String) {
//        model.clear()
//        search.forEach {
//            if (it.sideName.contains(query, ignoreCase = true) || it.name.contains(
//                    query,
//                    ignoreCase = true
//                )
//            ) {
//                model.add(it)
//            }else{
//
//            }
//        }
//        notifyDataSetChanged()
//    }

    private lateinit var itemClick: (Contact) -> Unit
    fun setItemClick(itemClick: (contact: Contact) -> Unit) {
        this.itemClick = itemClick
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sidename = itemView.rv_contact_sidename

        var name = itemView.rv_contact_name
        fun bind(contact: Contact) {
            sidename.text = contact.sideName

            name.text = contact.name


            itemView.setOnClickListener {
                itemClick.invoke(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }
//
    fun sumbitlist(list: List<Contact>) {
        model = list
    }

    override fun getItemCount() =
        model.size


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(model[position])
    }
}