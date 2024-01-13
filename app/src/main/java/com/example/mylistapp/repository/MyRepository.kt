package com.example.mylistapp.repository

import com.example.mylistapp.model.DataListModel
import retrofit2.Response

interface MyRepository {

    suspend fun getList(skip: Int): Response<DataListModel>

}