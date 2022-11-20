package com.example.aston5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Contact : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name: EditText? = requireActivity().findViewById<EditText?>(R.id.Name)
        val lastname: EditText? = requireActivity().findViewById<EditText?>(R.id.Surname)
        val number: EditText? = requireActivity().findViewById<EditText?>(R.id.Number)
        val info = arguments?.getParcelable<ContactStorage>("info")
        name?.setText(info?.firstName)
        lastname?.setText(info?.lastName)
        number?.setText(info?.phoneNumber)
        val id = info?.id?:0
        super.onViewCreated(view, savedInstanceState)
        val btn:Button = requireActivity().findViewById(R.id.btnsave)
        btn.setOnClickListener{
            val contact = ContactStorage(name?.text.toString(),lastname?.text.toString(),number?.text.toString(),id)
            setNewFragment(contact)
        }
    }

    private fun setNewFragment(contact: ContactStorage){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame, ContactsList.newInstance(contact=contact)).commit()
    }


    companion object {
        @JvmStatic
        fun newInstance(contact: ContactStorage) =
            Contact().apply {
                arguments = Bundle().apply {
                    putParcelable("info", contact)
                }
            }
    }
}