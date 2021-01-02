package com.example.jalgasplan.screens.addData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import kotlinx.android.synthetic.main.item_main.*


class AddDataFragment : Fragment() {
    private lateinit var mViewModel: AddDataFragmentViewModel
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

        btn_add_senside.setOnClickListener {
            initialization()
        }
    }
     private fun initialization() {
        mViewModel = ViewModelProvider(requireActivity()).get(AddDataFragmentViewModel::class.java)
         var sideName = mBinding.addSenside.text.toString().trim()
        var Name = mBinding.addSensideName.text.toString().trim()
        if (sideName.isNotEmpty() && Name.isNotEmpty()) {
            mViewModel.insert(
                Model(
                    name = Name,
                    id_name = sideName
                ), args.id.toString()
            )
            val action = AddDataFragmentDirections.actionAddDataFragmentToGeneralFragment(args.id)
            findNavController().navigate(action)
        } else {
            Toast.makeText(requireContext(), "Все поля должны быть заполнены", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}