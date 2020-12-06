package com.example.jalgasplan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Model
import kotlinx.android.synthetic.main.item_main.view.*


class General_adapter() : RecyclerView.Adapter<General_adapter.MainViewHolder>() {

      var model: ArrayList<Model> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id_name: TextView = itemView.id_name
        var name: TextView = itemView.name
        var address_name: TextView = itemView.address_name
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = model.size

    fun submitlist(list: ArrayList<Model>) {
       model = list
        notifyDataSetChanged()

        Log.d("jalgas1",list.toString())
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.name.text = model[position].name
        holder.id_name.text = model[position].id_name
        holder.address_name.text = model[position].address_name

        holder.address_name.text = model[position].address_name
        Log.d("jalgas2",holder.address_name.toString())
     }

//
//    fun deleteItem(position: Int){
//
//        list.removeAt(position)
//        notifyItemRemoved(position)
//    }

}