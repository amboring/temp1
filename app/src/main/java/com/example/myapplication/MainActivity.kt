package com.example.myapplication

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FirstFragment.onFragmentListener,
    SecondFragment.onFragmentListener,ThirdFragment.onFragmentListener{
    var name=""
    var email=""
    var phone=""
    var house=""
    var city=""
    var country=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder,FirstFragment()).commit()
    }

    override fun onClick(name: String, email: String,phone:String) {
        this.name=name
        this.email=email
        this.phone=phone
        var temp=SecondFragment.newInstance(name,email,phone)
        Log.i("***********","onClick")
        Log.i("**************", temp.toString())
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder,temp).commit()
   }

    override fun onClickSecond(house: String, city: String, country: String) {
        this.house=house
        this.city=city
        this.country=country

        Log.i("*************","onClickSecond")
        var person= Person(name,email,phone,house,city,country)


        var frag= ThirdFragment.newInstance(person)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder,frag).commit()
    }

    override fun onClickThird() {
        Log.i("****","onclickthird")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder,ThankYouFragment()).commit()
    }

}