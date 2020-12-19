package com.example.jalgasplan.screens.contact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.Contact_adapter
import com.example.jalgasplan.database.FirebaseRepository
import com.example.jalgasplan.databinding.FragmentContactBinding
import com.example.jalgasplan.model.Contact

import com.example.jalgasplan.screens.contact_items.ContactViewModel
import kotlin.collections.ArrayList

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: Contact_adapter
    private lateinit var mViewModel: ContactViewModel
    private lateinit var repos:FirebaseRepository
    private lateinit var mObservable: Observer<ArrayList<Contact>>


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
       // recyclerView = mBinding.recyclerView

        mAdapter = Contact_adapter()

        initialization()

        search()

    }

    private fun search() {
        mBinding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              mAdapter.filter(p0.toString())
            }

        })
    }

    private fun initialization() {
      //  repos = FirebaseRepository()
        mAdapter = Contact_adapter()
        recyclerView = mBinding.recyclerView
        recyclerView.adapter = mAdapter
        mObservable = Observer {
           var list   = it
           mAdapter.search(list)
           // mAdapter.sumbitlist(list)
           // mViewModel.contact(list)

            Log.i("jalgassss",list.toString())
        }
        mViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        mViewModel.contact()
           mViewModel.contact.observe(requireActivity(),mObservable)


//        var data = DataSource.createDataSet()
//        mAdapter.sumbitlist(data)
//        mAdapter.search(data)
        mAdapter.setItemClick {
            var id: Int = it.id
            var sideName = it.sideName
            val action =
                ContactFragmentDirections.actionContactFragmentToMainContactFragment(
                    sideName
                )
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}