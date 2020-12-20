package com.example.jalgasplan.screens.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.adapter.Main_contact_adapter
import com.example.jalgasplan.database.FirebaseRepository
import com.example.jalgasplan.databinding.FragmentMainContactBinding
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.android.synthetic.main.fragment_main_contact_.*


class Main_contact_Fragment : Fragment() {

    private var _binding: FragmentMainContactBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: Main_contact_adapter
    private val args: Main_contact_FragmentArgs by navArgs()
    private lateinit var mViewModel: MainContactViewModel
    private lateinit var mObervableList: Observer<ArrayList<Main_contact_model>>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainContactBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          addMainContact.setOnClickListener {
            var action =
                Main_contact_FragmentDirections.actionMainContactFragmentToAddToMainContactFragment(
                    sideName = args.sideName
                )
            findNavController().navigate(action)
        }
    }
    private fun deleteItem() {
        mAdapter = Main_contact_adapter(requireContext())
        mRecyclerView = mBinding.rvMainContact
        mRecyclerView.adapter = mAdapter
        mAdapter.setItemClickDelete {
            var a = it.idContact_firebase
            var b = it.name
            var s = it.phone
            val dialog: AlertDialog = AlertDialog.Builder(requireContext())
                .setMessage("Вы уверены что хотите удалить ? ")
                .setTitle("Удалить")
                .setPositiveButton("yes") { _, _ ->
                    mViewModel.main_ContactDelete(
                        Main_contact_model(a, b, s),
                        args.sideName.toString()
                    )
                    mViewModel.getContactData(args.sideName.toString())
                }
                .setNegativeButton("no", null)
                .create()
            dialog.show()
        }
    }
    override fun onResume() {
        super.onResume()
        REPOSITORY = FirebaseRepository(requireContext())
        initialization()
        deleteItem()
        args.sideName?.let { mViewModel.getContactData(it) }
          }

    private fun initialization() {
        mAdapter = Main_contact_adapter(requireContext())
        mRecyclerView = mBinding.rvMainContact
        mRecyclerView.adapter = mAdapter
        viewManager = LinearLayoutManager(requireContext())
        mRecyclerView.apply {
            adapter = mAdapter
            layoutManager = viewManager
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        mObervableList = Observer {
            var list = it
            mAdapter.sumbitList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainContactViewModel::class.java)
        mViewModel.contactLiveData.observe(requireActivity(), mObervableList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mViewModel.contactLiveData.removeObserver(mObervableList)
        mRecyclerView.adapter = null
    }
}