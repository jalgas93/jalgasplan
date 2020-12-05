package com.example.jalgasplan.screens.addData

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.jalgasplan.R
import com.example.jalgasplan.databinding.FragmentAddDataBinding
import com.example.jalgasplan.model.Month
import com.example.jalgasplan.model.Month2
import com.example.jalgasplan.screens.generalFragment.SwipeToDelete
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_add_data.*
import kotlinx.android.synthetic.main.fragment_general.*
import kotlinx.android.synthetic.main.fragment_start.view.*
import kotlinx.android.synthetic.main.item_main.*
import kotlinx.android.synthetic.main.item_main.address_name
import kotlinx.android.synthetic.main.item_main.id_name
import kotlinx.android.synthetic.main.item_main.name
import java.lang.Exception


class AddDataFragment : Fragment() {

    private  var TAG = "jalgas"
    private lateinit var database: FirebaseFirestore
    private var _binding: FragmentAddDataBinding? = null
    private val mBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddDataBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = FirebaseFirestore.getInstance()

        add.setOnClickListener {
            addData()
        }
    }
    private fun addData() {

        var sideName = id_name.text.toString().trim()
        var Name = name.text.toString().trim()
        var AddressName = address_name.text.toString().trim()

        if (sideName.isNotEmpty() && Name.isNotEmpty() && AddressName.isNotEmpty()) {
            var mode = Month2(sideName, Name, AddressName)
            database.collection("jalgas").add(mode)
                .addOnSuccessListener(object : OnSuccessListener<DocumentReference> {
                    override fun onSuccess(p0: DocumentReference?) {



                        id_name.setText("")
                        name.setText("")
                        address_name.setText("")


                        findNavController().navigate(R.id.action_addDataFragment_to_generalFragment)
                    }
                }).addOnFailureListener(object : OnFailureListener {
                    override fun onFailure(p0: Exception) {
                        Toast.makeText(requireContext(), "failed", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
   override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}