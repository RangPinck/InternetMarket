package com.example.internetshop.model

import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val id: Int,
    val ProdcutName: String,
    val Salary: Double,
    val Seller: String,
    val Image: String?
)