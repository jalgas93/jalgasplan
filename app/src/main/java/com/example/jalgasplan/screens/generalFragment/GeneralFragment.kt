package com.example.jalgasplan.screens.generalFragment

import android.os.Bundle
import android.util.Log
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
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.adapter.General_adapter
import com.example.jalgasplan.database.FirebaseRepository
import com.example.jalgasplan.databinding.FragmentGeneralBinding
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.android.synthetic.main.fragment_general.*
import kotlinx.android.synthetic.main.item_main.*


class GeneralFragment() : Fragment() {

    private val args: GeneralFragmentArgs by navArgs()
     private var _binding: FragmentGeneralBinding? = null
    private val mBinding get() = _binding!!
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
        generalFactory = GeneralFactory()
        mAdapter = General_adapter()
        mRecyclerView = mBinding!!.RvGeneral
        mRecyclerView.adapter = mAdapter
        mAdapter = General_adapter()
        mRecyclerView = mBinding.RvGeneral
        mRecyclerView.adapter = mAdapter
        REPOSITORY = FirebaseRepository(requireContext())
        initialization()
        deleteItem()
        selected()
        args.id?.let { mViewModel.getData(it) }
        Log.i("id",args.id.toString())
        fl_button.setOnClickListener {
            val action = GeneralFragmentDirections.actionGeneralFragmentToAddDataFragment(args.id)
            findNavController().navigate(action)
        }
    }

    private fun selected() {
        if (checkbox.isChecked){

        }
    }

    private fun deleteItem() {

        mAdapter.setItemClick {
            var b = it.name
            var s = it.id_name
            var d = it.idFirebase
            val dialog: AlertDialog = AlertDialog.Builder(requireContext())
                .setMessage("Вы уверены что хотите удалить ? ")
                .setTitle("Удалить")
                .setPositiveButton("yes") { _, _ ->
                    mViewModel.deleteItem(
                        Model( d, s, b),
                        args.id.toString()
                    )
                    mViewModel.getData(args.id.toString())
                }
                .setNegativeButton("no", null)
                .create()
            dialog.show()
        }
    }
    private fun initialization() {
        setHasOptionsMenu(true)
              mRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        mObserverList = Observer {
            val list = it
            mAdapter.submitlist(list)
            Log.d("jalgas4", list.toString())
        }
        mViewModel =
            ViewModelProvider(this).get(GeneralFragmentViewModel::class.java)
        mViewModel.allModels.observe(requireActivity(), mObserverList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
      //  mViewModel.allModels.removeObserver(mObserverList)
      //  mRecyclerView.adapter = null
    }
}