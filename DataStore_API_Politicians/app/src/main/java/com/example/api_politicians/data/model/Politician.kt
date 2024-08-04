package com.example.api_politicians.data.model

data class Politician(
    var id:Int,
    var name:String,
    var dob: String,
    var country: String,
    var party:String,
    var position:String,
    var years_in_office: String,
    var image: String,
    var biography:String
)