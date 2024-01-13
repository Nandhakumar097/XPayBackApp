package com.example.mylistapp.model

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
): Serializable