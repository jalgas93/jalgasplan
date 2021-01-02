package com.example.jalgasplan.screens.contact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.MainActivity
import com.example.jalgasplan.Room.BsDatabase
import com.example.jalgasplan.Room.UserDao
import com.example.jalgasplan.adapter.Contact_adapter
import com.example.jalgasplan.database.FirebaseRepository
import com.example.jalgasplan.databinding.FragmentContactBinding
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.repository.MainRepository


import com.example.jalgasplan.screens.contact_items.ContactViewModel
import com.example.jalgasplan.utils.APP_Activity
import com.example.jalgasplan.utils.REPOSITORY
import kotlin.collections.ArrayList

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: Contact_adapter
    private lateinit var mViewModel: ContactViewModel

   private lateinit var mObservable: Observer<List<Contact>>
  //  private lateinit var mFactory: ContactFactory
    private lateinit var dao: UserDao

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
        val repository = MainRepository()
        APP_Activity = MainActivity()
        dao = BsDatabase.getInstance(requireContext()).getDao()
      //  mFactory = ContactFactory(repository)
        REPOSITORY = FirebaseRepository(requireContext())
        mAdapter = Contact_adapter(view)
        recyclerView = mBinding.recyclerView
        recyclerView.adapter = mAdapter

        initialization()
        search()
        //delete()
        //insert()

    }


    private fun delete() {
        mViewModel.deleteData(Contact(1, "KAR1100", "Водник"))
    }

    private fun insert() {
        mViewModel.insertData(Contact(0, "KAR1100", "Водник"))
        mViewModel.insertData(Contact(1, "KAR1101", "Кипчак"))
        mViewModel.insertData(Contact(138, "KAR1239", "Тулкин"))
        mViewModel.insertData(Contact(164, "KAR1265", "Учсай"))
        mViewModel.insertData(Contact(165, "KAR1266", "Полигон"))
    }

    private fun search() {
        mBinding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mAdapter.filter(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
         //  var result:List<Contact> = dao.search(sideName ="${it.toString()}%" , name = "${it.toString()}%")

//
//        mBinding.etSearch.addTextChangedListener {
//            //var list: List<Contact> = dao.search("${it.toString()}%")
//
//                  }
    }

    private fun initialization() {


        mObservable = Observer {
            var list = it
            Log.i("jalgas",list.toString())
             mAdapter.search(list)
        //  mAdapter.sumbitlist(list)
            // mViewModel.contact(list)
            //  mViewModel.insertDataLive(list)

                 }
        mViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        mViewModel.contacts()
         // var a =   mViewModel.contacts()
   //   Log.i("list",a.toString())
    //   mAdapter.sumbitlist(a)
        mViewModel.contactLiveData.observe(requireActivity(), mObservable)
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