package com.example.internetshop.view.startscreen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.startscreen.StartScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun DelayBeforeSwitch(navController: NavController) {
    val viewvModel = StartScreenViewModel()
    LaunchedEffect(Unit) {
        viewvModel.GetCurentUser()
        delay(1000L)
        viewvModel.navNext(navController)
    }
}