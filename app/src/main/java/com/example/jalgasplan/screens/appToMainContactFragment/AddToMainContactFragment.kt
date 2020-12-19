package com.example.jalgasplan.screens.appToMainContactFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentAddToMainContactBinding
import com.example.jalgasplan.model.Main_contact_model
import kotlinx.android.synthetic.main.fragment_add_to_main_contact.*


class AddToMainContactFragment : Fragment() {

    private var _binding: FragmentAddToMainContactBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddMainContactViewModel
    private val args: AddToMainContactFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddToMainContactBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_data.setOnClickListener {
            initialization()
        }
    }

    private fun initialization() {
        var text = mBinding.etText.text.toString().trim()
        var phone = mBinding.etPhone.text.toString().trim()
        mViewModel = ViewModelProvider(requireActivity()).get(AddMainContactViewModel::class.java)
        if (text.isNotEmpty() && phone.isNotEmpty()) {
            args.sideName?.let {
                mViewModel.insertAddMainContact(
                    Main_contact_model(name = text, phone = phone), it

                )
            }
            Toast.makeText(requireContext(), "Данные добавлено", Toast.LENGTH_SHORT)
                .show()
            var action =
                AddToMainContactFragmentDirections.actionAddToMainContactFragmentToMainContactFragment(
                    args.sideName
                )
            findNavController().navigate(action)
        } else {
            Toast.makeText(requireContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}