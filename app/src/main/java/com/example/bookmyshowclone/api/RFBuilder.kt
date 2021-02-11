package com.example.apidemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RFBuilder {

    var baseURL = "http://api.kabadishop.in/Service/"

    var builder = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val placeHolderAPI: JSON_Getter = builder.create(JSON_Getter::class.java)
}