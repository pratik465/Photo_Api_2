package com.pachchham.photoapi

import com.pachchham.photoapi.Model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    fun getPhoto(
        @Header("Authorization")auth:String,
        @Query("query")query:String
    ): Call<PhotoModel>



}