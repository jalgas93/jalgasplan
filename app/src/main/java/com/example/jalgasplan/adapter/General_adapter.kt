package com.example.jalgasplan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.model.Month
import com.example.jalgasplan.model.Month2
import kotlinx.android.synthetic.main.item_main.view.*


class General_adapter(var list:ArrayList<Month2>) : RecyclerView.Adapter<General_adapter.mainViewHolder>() {


//
//      var model: List<Month> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


//    var jalgas: List<Month> = arrayListOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }




    inner class mainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id_name: TextView = itemView.id_name
        var name: TextView = itemView.name
        var address_name: TextView = itemView.address_name
        fun bind(month: Month) {

            id_name.text = month.id_name
            name.text = month.name
            address_name.text = month.address_name


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return mainViewHolder(view)
    }

    override fun getItemCount(): Int =
        list.size

//    fun submitlist(list: List<Month>) {
//
//       model = list
//
//    }

    override fun onBindViewHolder(holder: mainViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.id_name.text = list[position].id_name

        holder.address_name.text = list[position].address_name

        //holder.bind(list[position])
    }


    fun deleteItem(position: Int){

        list.removeAt(position)
        notifyItemRemoved(position)
    }

}