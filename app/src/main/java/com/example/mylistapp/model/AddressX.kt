package com.example.mylistapp.model

import java.io.Serializable

data class AddressX(
    val address: String,
    val city: String,
    val coordinates: CoordinatesX,
    val postalCode: String,
    val state: String
): Serializable