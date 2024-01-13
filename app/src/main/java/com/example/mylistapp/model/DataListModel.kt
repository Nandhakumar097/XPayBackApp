package com.example.mylistapp.model

import java.io.Serializable

data class DataListModel(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: MutableList<User>
) : Serializable