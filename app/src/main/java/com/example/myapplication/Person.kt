package com.example.myapplication

import java.io.Serializable

data class Person (
    var name: String,
    var email:String,
    var tel:String,
    val house:String,
    val city:String,
    val country:String) : Serializable{
    companion object{
        const val KEY="humanbeings"
    }
}