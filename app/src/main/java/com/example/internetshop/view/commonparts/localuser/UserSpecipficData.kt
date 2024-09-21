package com.example.internetshop.view.commonparts.localuser

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object UserSpecipficData {
    val id: MutableState<String> = mutableStateOf("")
    val Name: MutableState<String> = mutableStateOf("")
    val Email: MutableState<String> = mutableStateOf("")
    val ProfileImage: MutableState<String?> = mutableStateOf(null)
    val Role: MutableState<Int> = mutableStateOf(0)
}