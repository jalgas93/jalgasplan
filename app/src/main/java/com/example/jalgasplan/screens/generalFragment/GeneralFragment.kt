package com.example.jalgasplan.screens.generalFragment

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.General_adapter
import com.example.jalgasplan.database.FirebaseRepository
import com.example.jalgasplan.databinding.FragmentGeneralBinding
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.utils.DataSource
import com.example.jalgasplan.utils.REPOSITORY
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_general.*


class GeneralFragment() : Fragment() {

    private val args:GeneralFragmentArgs by navArgs()
    private lateinit var database: FirebaseFirestore
    private var _binding: FragmentGeneralBinding? = null
    private val mBinding get() = _binding
    private lateinit var mViewModel: GeneralFragmentViewModel
    private lateinit var mAdapter: General_adapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mObserverList: Observer<ArrayList<Model>>
    private lateinit var generalFactory: GeneralFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGeneralBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        REPOSITORY = FirebaseRepository()
        initialization()
        database = FirebaseFirestore.getInstance()
             mViewModel.getData(args.id)
        Log.i("jalgas",args.id)
        fl_button.setOnClickListener {
            findNavController().navigate(R.id.action_generalFragment_to_addDataFragment)
        }
    }
        private fun initialization() {
        setHasOptionsMenu(true)
        generalFactory = GeneralFactory()
        mAdapter = General_adapter()
        mRecyclerView = mBinding!!.RvGeneral
        mRecyclerView.adapter = mAdapter
        // mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it
            mAdapter.submitlist(list)
        }
            mViewModel = ViewModelProvider(this, generalFactory).get(GeneralFragmentViewModel::class.java)
        mViewModel.allModels.observe(requireActivity(), mObserverList)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mViewModel.allModels.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
}