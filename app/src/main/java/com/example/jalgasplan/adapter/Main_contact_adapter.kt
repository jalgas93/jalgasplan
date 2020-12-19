package com.example.jalgasplan.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Main_contact_model
import kotlinx.android.synthetic.main.item_main_contact.*
import kotlinx.android.synthetic.main.item_main_contact.view.*

class Main_contact_adapter(var context: Context):RecyclerView.Adapter<Main_contact_adapter.MainContactViewHolder>() {
    var main_contact:ArrayList<Main_contact_model> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
private lateinit var itemClick:(Main_contact_model)->Unit
    fun setItemClickDelete(itemClick:(main_contact_model:Main_contact_model)->Unit){
        this.itemClick  = itemClick
    }
    inner class MainContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemText = itemView.Main_text
        var phone = itemView.phone
        var call = itemView.btn_call
        fun bind(contact:Main_contact_model){
            itemText.text = contact.name
            phone.text = contact.phone
            itemView.delete.setOnClickListener {
                itemClick.invoke(contact)
            }
            call.setOnClickListener {
               var number = phone.text.toString()
                val u = Uri.parse("tel:" + "${number}")
                Log.i("jalgas_number",phone.toString())
                val i = Intent(Intent.ACTION_DIAL, u)
                try {
                    context.startActivity(i)
                } catch (s: SecurityException) {
                    Toast.makeText(context, "Ошибка при вызове", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainContactViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_contact,parent,false)
        return MainContactViewHolder(view)
    }
    override fun getItemCount() = main_contact.size
    fun sumbitList(list:ArrayList<Main_contact_model>){
        main_contact = list
        Log.d("jalgas/6",list.toString())
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MainContactViewHolder, position: Int) {
        holder.bind(main_contact[position])
    }
}