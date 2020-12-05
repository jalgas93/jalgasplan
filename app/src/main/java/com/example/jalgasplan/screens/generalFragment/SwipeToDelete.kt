package com.example.jalgasplan.screens.generalFragment

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.adapter.General_adapter

class SwipeToDelete(var adapter:General_adapter):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("   ")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        
       var position = viewHolder.adapterPosition
       adapter.deleteItem(position)
    }

}