package com.example.jalgasplan.screens.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentMainContactBinding
import kotlinx.android.synthetic.main.fragment_add_to_main_contact.*


class Main_contact_Fragment : Fragment() {

    private var _binding:FragmentMainContactBinding? = null
    private val mBinding get() = _binding
    private lateinit var mRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentMainContactBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        add_mainContact.setOnClickListener {
            findNavController().navigate(R.id.action_main_contact_Fragment_to_addToMainContactFragment)
        }

    }

    private fun initialization() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}