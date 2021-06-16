package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.util.Log
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ThirdFragment : Fragment() {
    private var person: Person? = null
    var listener: onFragmentListener?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            person = it.getSerializable(ARG_PARAM1) as Person?
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener= context as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var view= inflater.inflate(R.layout.fragment_third, container, false)

        init(view)
        return view
    }

    private fun init(view: View) {

        view.text_name.text= person?.name
        view.text_email.text= person?.email
        view.text_phone.text= person?.tel
        view.text_house.text= person?.house
        view.text_city.text= person?.city
        view.text_country.text= person?.country



        view.button_submit.setOnClickListener {
            Log.i("******",listener.toString())
            listener?.onClickThird()
        }


    }


    companion object {

        @JvmStatic
        fun newInstance(param1: Person) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }

    interface onFragmentListener{
        fun onClickThird()
    }

}