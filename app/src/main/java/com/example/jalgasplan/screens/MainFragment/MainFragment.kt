package com.example.jalgasplan.screens.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.Main_adapter
import com.example.jalgasplan.databinding.FragmentMainBinding
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.utils.DataSource
import kotlinx.android.synthetic.main.item_main.*


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter:Main_adapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mObserverList: Observer<List<Model>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        addDataSet()
    }

    override fun onStart() {
        super.onStart()

    }

        private fun addDataSet(){
            var data  = DataSource.createDataSet()
            mAdapter.submitlist(data)
        }

    private fun initialization() {
        setHasOptionsMenu(true)

       mAdapter = Main_adapter()
        mRecyclerView = mBinding.recycler
        mRecyclerView.adapter = mAdapter





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}