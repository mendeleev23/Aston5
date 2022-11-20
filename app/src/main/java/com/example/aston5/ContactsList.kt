package com.example.aston5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ContactsList : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val info = arguments?.getParcelable<ContactStorage>("info")
        when(info?.id){
            1->{
                requireActivity().findViewById<TextView>(R.id.Name_12)?.text=info.firstName
                requireActivity().findViewById<TextView>(R.id.Surname_12)?.text=info.lastName
                requireActivity().findViewById<TextView>(R.id.Number_12)?.text=info.phoneNumber
            }
            2->{
                requireActivity().findViewById<TextView>(R.id.Name_22)?.text=info.firstName
                requireActivity().findViewById<TextView>(R.id.Surname_22)?.text=info.lastName
                requireActivity().findViewById<TextView>(R.id.Number_22)?.text=info.phoneNumber
            }
            3->{
                requireActivity().findViewById<TextView>(R.id.Name_32)?.text=info.firstName
                requireActivity().findViewById<TextView>(R.id.Surname_32)?.text=info.lastName
                requireActivity().findViewById<TextView>(R.id.Number_32)?.text=info.phoneNumber
            }
        }
        val p1 = (requireActivity().findViewById<ConstraintLayout>(R.id.chel1))
        val p2 = (requireActivity().findViewById<ConstraintLayout>(R.id.chel2))
        val p3 = (requireActivity().findViewById<ConstraintLayout>(R.id.chel3))
        p1?.setOnClickListener{
            val contact = ContactStorage(
                requireActivity().findViewById<TextView>(R.id.Name_12)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Surname_12)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Number_12)?.text.toString(),1)
            setNewFragment(contact)
        }
        p2?.setOnClickListener{
            val contact = ContactStorage(
                requireActivity().findViewById<TextView>(R.id.Name_22)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Surname_22)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Number_22)?.text.toString(),2)
            setNewFragment(contact)
        }
        p3?.setOnClickListener{
            val contact = ContactStorage(
                requireActivity().findViewById<TextView>(R.id.Name_32)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Surname_32)?.text.toString(),
                requireActivity().findViewById<TextView>(R.id.Number_32)?.text.toString(),3)
            setNewFragment(contact)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setNewFragment(contact: ContactStorage){
        requireActivity().supportFragmentManager.beginTransaction().addToBackStack("list")
            .replace(R.id.frame, Contact.newInstance(contact=contact)).commit()
    }


    companion object {
        @JvmStatic
        fun newInstance(contact: ContactStorage) =
            ContactsList().apply {
                arguments = Bundle().apply {
                    putParcelable("info", contact)
                }
            }
    }

}