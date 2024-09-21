package com.example.internetshop.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val Name: String,
    val Email: String,
    val ProfileImage: String?,
    val Role: Int
)