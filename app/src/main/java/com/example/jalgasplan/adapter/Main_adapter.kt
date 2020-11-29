package com.example.jalgasplan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.model.Month
import kotlinx.android.synthetic.main.item_main.view.*


class Main_adapter : RecyclerView.Adapter<Main_adapter.mainViewHolder>() {

//    var model: List<Model> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }


    var jalgas: List<Month> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class mainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var yanvar:TextView = itemView.month
        fun bind(month: Month) {

           yanvar.text = month.yanvar


        }



}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainViewHolder {
    var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
    return mainViewHolder(view)
}

override fun getItemCount(): Int =
    jalgas.size

    fun submitlist(list:List<Month>){

        jalgas = list

    }

override fun onBindViewHolder(holder: mainViewHolder, position: Int) {
holder.bind(jalgas[position])
}

}