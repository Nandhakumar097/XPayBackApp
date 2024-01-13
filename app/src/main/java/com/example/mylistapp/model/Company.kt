package com.example.mylistapp.model

import java.io.Serializable

data class Company(
    val address: AddressX,
    val department: String,
    val name: String,
    val title: String
): Serializable