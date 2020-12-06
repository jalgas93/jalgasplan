package com.example.jalgasplan.screens.appToMainContactFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentAddToMainContactBinding
import com.example.jalgasplan.model.Main_contact_model
import kotlinx.android.synthetic.main.fragment_add_to_main_contact.*


class AddToMainContactFragment : Fragment() {

    private var _binding: FragmentAddToMainContactBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddMainContactViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddToMainContactBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        add_mainContact.setOnClickListener {
            findNavController().navigate(R.id.action_addToMainContactFragment_to_main_contact_Fragment)
        }
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(requireActivity()).get(AddMainContactViewModel::class.java)
        var sidename = mBinding.sideName.text.toString().trim()
        var fider1 = mBinding.fider1.text.toString().trim()
        var tp1 = mBinding.tp1.text.trim()
        var fider2 = mBinding.fider2.text.toString().trim()
        var tp2 = mBinding.tp2.text.toString().trim()
        var upr = mBinding.upr.text.toString().trim()
        var res = mBinding.res.text.toString().trim()
        var resMobile1 = mBinding.resMobile1.text.toString().trim()
        var resMobile2 = mBinding.resMobile2.text.toString().trim()
        var rut1 = mBinding.rut1.text.toString().trim()
        var rut2 = mBinding.rut2.text.toString().trim()
        var masterName = mBinding.masterName1.text.toString().trim()
        var master1 = mBinding.master1.text.toString().trim()
        var masterName2 = mBinding.masterName2.text.toString().trim()
        var master2 = mBinding.master2.text.toString().trim()
        var securityName = mBinding.oxranaName.text.toString().trim()
        var security = mBinding.oxrana.text.toString().trim()
        var zavxozName = mBinding.zavxozName.text.toString().trim()
        var zavxoz = mBinding.zavxoz.text.toString().trim()
        mViewModel.insertAddMainContact(
            Main_contact_model(
                sideName = sidename, fider1 = fider1, fider2 = fider2, tp2 = tp2,
                resUpr = upr, resMobile = resMobile1, resMobile2 = resMobile2, telecom1 = rut1,
                telecom2 = rut2, masterName1 = masterName, masterPhone = master1,
                masterName2 = masterName2, masterPhone2 = master2,
                securityName = securityName, securityPhone = security,
                zavhozName = zavxozName, zavhozPhone = zavxoz
            )
        )


    }

    override fun onDestroy() {
        super.onDestroy()
    }


}