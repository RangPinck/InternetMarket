package com.example.internetshop.model

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val id : Int,
    val RoleName : String
)