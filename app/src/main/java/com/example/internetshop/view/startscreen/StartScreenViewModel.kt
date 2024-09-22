package com.example.internetshop.view.startscreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes

class StartScreenViewModel() : ViewModel() {
    fun navNext(navController: NavController){
        val nav = NavigationFun()
        nav.GoToNextScreen(navController, Routes.Start.route, Routes.Market.route)
    }
}