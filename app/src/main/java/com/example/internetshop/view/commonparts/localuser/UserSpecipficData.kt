package com.example.internetshop.view.commonparts.localuser

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object UserSpecificData {
    val id: MutableState<String> = mutableStateOf("")
    val Role: MutableState<Int> = mutableStateOf(0)
}