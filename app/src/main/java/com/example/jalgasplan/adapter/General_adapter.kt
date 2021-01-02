package com.example.jalgasplan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.model.Model
import kotlinx.android.synthetic.main.fragment_add_data.view.*
import kotlinx.android.synthetic.main.item_main.view.*



class General_adapter() : RecyclerView.Adapter<General_adapter.MainViewHolder>() {

    var model: ArrayList<Model> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private lateinit var itemClickk: (Model) -> Unit
    fun setItemClick(itemClicka: (model: Model) -> Unit) {
        this.itemClickk = itemClicka
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // var senside: TextView = itemView.add_senside
        //var senside_name: TextView = itemView.add_senside_name
        var tv_sideName = itemView.tv_sideName
        var tv_side_number = itemView.tv_side_number



        fun bind(model: Model) {
           // senside.text = model.id_name
           // senside_name.text = model.name
            tv_sideName.text = model.name
            tv_side_number.text = model.id_name
            itemView.btn_delete.setOnClickListener {

                itemClickk.invoke(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = model.size
    fun submitlist(list: ArrayList<Model>) {
        model = list
        Log.d("jalgas1", list.toString())
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        holder.name.text = model[position].name
//        holder.id_name.text = model[position].id_name
//        holder.address_name.text = model[position].address_name
//        holder.address_name.text = model[position].address_name
               holder.bind(model[position])
    }

}