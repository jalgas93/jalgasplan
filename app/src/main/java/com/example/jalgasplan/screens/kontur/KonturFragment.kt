package com.example.jalgasplan.screens.kontur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentKonturBinding

class KonturFragment : Fragment() {
    private var _binding: FragmentKonturBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKonturBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var value = arrayOf(
            "Январь",
            "Февраль",
            "Март",
            "Апрель",
            "Май",
            "Июнь",
            "Июл",
            "Августь",
            "Сентябрь",
            "Октябрь",
            "Ноябрь",
            "Декабрь"
        )
        var list = view.findViewById<ListView>(R.id.kontur_listView)
        var adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,value)
        list.adapter = adapter

         list.setOnItemClickListener { adapterView, view, position, l ->
             if (position == 0 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("yan")
                 findNavController().navigate(action)
             }
             if (position == 1 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("fev")
                 findNavController().navigate(action)
             }
             if (position == 2 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("mar")
                 findNavController().navigate(action)
             }
             if (position == 3 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("apr")
                 findNavController().navigate(action)
             }
             if (position == 4 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("may")
                 findNavController().navigate(action)
             }
             if (position == 5 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("iyu")
                 findNavController().navigate(action)
             }
             if (position == 6 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("iyull")
                 findNavController().navigate(action)
             }
             if (position == 7 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("avg")
                 findNavController().navigate(action)
             }
             if (position == 8 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("sen")
                 findNavController().navigate(action)
             }
             if (position == 9 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("okt")
                 findNavController().navigate(action)
             }
             if (position == 10 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("noy")
                 findNavController().navigate(action)
             }
             if (position == 11 ){
                 var action = KonturFragmentDirections.actionKonturFragmentToGeneralFragment("dek")
                 findNavController().navigate(action)
             }
         }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}