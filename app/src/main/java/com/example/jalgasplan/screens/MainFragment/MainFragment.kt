package com.example.jalgasplan.screens.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.General_adapter
import com.example.jalgasplan.databinding.FragmentMainBinding
import com.example.jalgasplan.model.Model


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var value = arrayOf<String>(
            "Перемещение кондиционера",
            "Pасходы во время ремонта",
            "Январь",
            "Февраль",
            "Март",
            "Апрель",
            "Май",
            "Июнь",
            "Июль",
            "Август",
            "Сентябрь",
            "Октябрь"
        )
        val mListView = view.findViewById<ListView>(R.id.ListView)
        var adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, value)

        mListView.adapter = adapter

        mListView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Peremeshenie")
                findNavController().navigate(action)
            }
            if (position == 1) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Rasxodi")
                findNavController().navigate(action)
            }
            if (position == 2) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Yanvar")
                findNavController().navigate(action)
            }
            if (position == 3) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Fevral")
                findNavController().navigate(action)
            }
            if (position == 4) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Mart")
                findNavController().navigate(action)
            }
            if (position == 5) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Aprel")
                findNavController().navigate(action)
            }
            if (position == 6) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("May")
                findNavController().navigate(action)
            }
            if (position == 7) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Iyun")
                findNavController().navigate(action)
            }
            if (position == 8) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Iyul")
                findNavController().navigate(action)
            }
            if (position == 9) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Avgust")
                findNavController().navigate(action)
            }
            if (position == 10) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Sentyabr")
                findNavController().navigate(action)
            }
            if (position == 11) {
                val action = MainFragmentDirections.actionMainFragmentToGeneralFragment("Oktyabr")
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}