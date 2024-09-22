package com.example.internetshop.view.startscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.localuser.CurrentUserData
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import kotlinx.coroutines.launch

class StartScreenViewModel() : ViewModel() {

    fun navNext(navController: NavController) {
        val nav = NavigationFun()
        nav.GoToNextScreen(navController, Routes.Start.route, Routes.Market.route)
    }

    fun GetCurentUser(){
        val userData = CurrentUserData()
        viewModelScope.launch {
            userData.RefreshCurrantSession()
            userData.GetSpecificUserData()
        }
    }
}