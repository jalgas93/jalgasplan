package com.example.jalgasplan.screens.generalFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.jalgasplan.R
import com.example.jalgasplan.adapter.General_adapter
import com.example.jalgasplan.databinding.FragmentGeneralBinding
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.model.Month
import com.example.jalgasplan.model.Month2
import com.example.jalgasplan.utils.DataSource
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.Timestamp
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_general.*
import java.util.*
import kotlin.collections.ArrayList


class GeneralFragment : Fragment() {
    private lateinit var database: FirebaseFirestore
    private var _binding: FragmentGeneralBinding? = null
    private val mBinding get() = _binding
    private lateinit var mAdapter: General_adapter
    private lateinit var mRecyclerView: RecyclerView
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
        database = FirebaseFirestore.getInstance()
        // initialization()
        addDataSet()
        getData()
        deleteInFirestore()
        // swipeToDelete()
        fl_button.setOnClickListener {
            findNavController().navigate(R.id.action_generalFragment_to_addDataFragment)
        }
    }

    private fun addDataSet() {
        // var data  = DataSource.createDataSet()
        // mAdapter.submitlist(data)
    }

    private fun initialization() {
        setHasOptionsMenu(true)
    }

    private fun deleteInFirestore() {
        database.collection("yanvar")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("jalgas", "${document.id} => ${document.data}")
                    Log.i("jalgas", "${document.id}")
                    var itemTouchHelper = ItemTouchHelper(SwipeToDelete(mAdapter))

                    database.collection("jalgas").document("jal")
                        .delete()
                        .addOnSuccessListener {
                            itemTouchHelper.attachToRecyclerView(mRecyclerView)

                            Log.d("jalgas", "DocumentSnapshot successfully deleted!")
                        }
                        .addOnFailureListener { e -> Log.w("jalgas", "Error deleting document", e) }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("jalgas", "Error getting documents: ", exception)
            }
    }

    private fun getData() {
        database.collection("jalgas").get()
            .addOnCompleteListener(object : OnCompleteListener<QuerySnapshot> {
                override fun onComplete(p0: Task<QuerySnapshot>) {
                    var model = ArrayList<Month2>()
                    if (p0.isSuccessful) {
                        for (data in p0.result!!) {
                            model.add(
                                Month2(
                                    data.get("id_name") as String,
                                    data.get("name") as String,
                                    data.get("address_name") as String
                                )
                            )
                        }
                        mAdapter = General_adapter(model)
                        mRecyclerView = mBinding!!.RvGeneral
                        mRecyclerView.adapter = mAdapter
                    }
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}