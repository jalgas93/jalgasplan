package com.example.jalgasplan.screens.addData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentAddDataBinding
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.screens.MainFragment.MainFragmentDirections
import com.example.jalgasplan.screens.generalFragment.GeneralFragmentArgs
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_add_data.*


class AddDataFragment : Fragment() {
    private lateinit var mViewModel: AddDataFragmentViewModel

    private var TAG = "jalgas"
    private val args: AddDataFragmentArgs by navArgs()
    private lateinit var database: FirebaseFirestore
    private var _binding: FragmentAddDataBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddDataBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialization()
        //args.id?.let { mViewModel.(it) }
        add.setOnClickListener {
            initialization()
            val action = AddDataFragmentDirections.actionAddDataFragmentToGeneralFragment(args.id)
            findNavController().navigate(action)
        }

    }

    override fun onResume() {
        super.onResume()
        database = FirebaseFirestore.getInstance()
    }
    private fun initialization() {
        mViewModel = ViewModelProvider(requireActivity()).get(AddDataFragmentViewModel::class.java)
        var sideName = mBinding.idName.text.toString().trim()
        var Name = mBinding.name.text.toString().trim()
        var AddressName = mBinding.addressName.text.toString().trim()
        // var id = mBinding.id.text.toString()
        if (sideName.isNotEmpty() && Name.isNotEmpty() && AddressName.isNotEmpty()) {
            mViewModel.insert(
                Model(
                    args.id.toString(),
                    name = Name,
                    id_name = sideName,
                    address_name = AddressName
                ), args.id.toString()
            )
                //findNavController().navigate(R.id.action_addDataFragment_to_generalFragment)


        }
    }
        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }
    }