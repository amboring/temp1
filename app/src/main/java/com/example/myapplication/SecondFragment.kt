package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {


    var listener:onFragmentListener?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_second, container, false)

        init(view)
        return view
    }

    private fun init(view: View) {
        view.button_next.setOnClickListener {
            var house=view.edit_text_house.text.toString()
            var city=view.edit_text_city.text.toString()
            var country =view.edit_text_country.text.toString()

            Log.i("**************","second frag init")
            listener?.onClickSecond(house,city,country)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener= context as MainActivity
    }

    interface onFragmentListener{
        fun onClickSecond(name:String, email:String,phone:String)
    }
    companion object {

        @JvmStatic
        fun newInstance(name: String,email:String,phone:String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(name, "name")
                    putString(email,"email")
                    putString(phone,"phone")
                }
            }
    }


}