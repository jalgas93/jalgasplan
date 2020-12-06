package com.example.jalgasplan.screens.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.Contact_adapter
import com.example.jalgasplan.databinding.FragmentContactBinding
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.screens.kontur.KonturFragmentDirections
import com.example.jalgasplan.utils.DataSource

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val mBinding get() = _binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: Contact_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        mAdapter = Contact_adapter()
        recyclerView.adapter = mAdapter
        initialization()



    }

    private fun initialization() {
        var data = DataSource.createDataSet()
         mAdapter.sumbitlist(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}