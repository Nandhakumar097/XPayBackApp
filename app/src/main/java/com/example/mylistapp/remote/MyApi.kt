package com.example.mylistapp.remote

import com.example.mylistapp.model.DataListModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("/users")
    suspend fun getList(@Query("limit") limit : Int = 10, @Query("skip") skip : Int) : Response<DataListModel>

}