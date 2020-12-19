package com.example.jalgasplan.screens.generalFragment

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.adapter.General_adapter
import com.example.jalgasplan.adapter.Main_contact_adapter
import com.example.jalgasplan.model.Main_contact_model

class SwipeToDelete(var adapter:Main_contact_adapter):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("   ")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        
       var position = viewHolder.adapterPosition
       //adapter.deleteItem(position)
//        adapter.setItemClickDelete {
//            var idFirebase = it.idContact_firebase
//            var name = it.name
//            var phone = it.phone
//            mViewModel.main_ContactDelete(
//                Main_contact_model(idFirebase,name,phone),
//                args.sideName.toString()
//            )
//        }




    }

}