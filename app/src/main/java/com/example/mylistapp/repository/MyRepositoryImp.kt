package com.example.mylistapp.repository

import com.example.mylistapp.model.DataListModel
import com.example.mylistapp.remote.MyApi
import retrofit2.Response

class MyRepositoryImp(private val myApi: MyApi) : MyRepository {
    override suspend fun getList(skip: Int): Response<DataListModel> {
        return myApi.getList(skip = skip)
    }
}