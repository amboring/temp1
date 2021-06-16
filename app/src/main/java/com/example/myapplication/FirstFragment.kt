package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

    var listener:onFragmentListener?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_first, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        view.button_next.setOnClickListener {
            var name=view.edit_text_name.text.toString()
            var email=view.edit_text_email.text.toString()
            var phone =view.edit_text_phone.text.toString()
            listener?.onClick(name,email,phone)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener= context as MainActivity
    }

    interface onFragmentListener{
        fun onClick(name:String, email:String,phone:String)
    }


}