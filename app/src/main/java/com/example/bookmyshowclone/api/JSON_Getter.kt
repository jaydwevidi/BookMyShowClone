package com.example.apidemo.api

import com.example.apidemo.model.CompleteData
import retrofit2.Call
import retrofit2.http.GET

interface JSON_Getter {

    @GET("CityList")
    fun getCityList(): Call<CompleteData>

    /*@GET("CityList")
    fun getColours() : Call<List<Colour>>*/
}