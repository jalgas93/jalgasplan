package com.example.jalgasplan.screens.electro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentElectroBinding


class ElectroFragment : Fragment() {

    private var _binding: FragmentElectroBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentElectroBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var value = arrayOf<String>(
            "Январь",
            "Февраль",
            "Март",
            "Апрель",
            "Май",
            "Июнь",
            "Июль",
            "Август",
            "Сентябрь",
            "Октябрь",
            "Ноябрь",
            "Декабрь"
        )

        val mListViewElectro = view.findViewById<ListView>(R.id.electro_listView)
        var adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, value)
        mListViewElectro.adapter = adapter
        mListViewElectro.setOnItemClickListener { adapterView, view, position, l ->

            if (position == 0) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("yanvar")
                findNavController().navigate(action)
            }
            if (position == 1) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("fevral")
                findNavController().navigate(action)
            }
            if (position == 2) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("mart")
                findNavController().navigate(action)
            }
            if (position == 3) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("yanvar")
                findNavController().navigate(action)
            }
            if (position == 4) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("fevral")
                findNavController().navigate(action)
            }
            if (position == 5) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("mart")
                findNavController().navigate(action)
            }
            if (position == 6) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("yanvar")
                findNavController().navigate(action)
            }
            if (position == 7) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("fevral")
                findNavController().navigate(action)
            }
            if (position == 8) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("mart")
                findNavController().navigate(action)
            }
            if (position == 9) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("yanvar")
                findNavController().navigate(action)
            }
            if (position == 10) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("fevral")
                findNavController().navigate(action)
            }
            if (position == 11) {
                var action =
                    ElectroFragmentDirections.actionElectroFragment2ToGeneralFragment("mart")
                findNavController().navigate(action)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}