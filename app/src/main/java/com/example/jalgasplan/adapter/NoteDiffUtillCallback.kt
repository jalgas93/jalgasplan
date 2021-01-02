package com.example.jalgasplan.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.jalgasplan.model.Contact

class NoteDiffUtillCallback:DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.name == oldItem.name
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
      return oldItem.name == oldItem.name
    }
}