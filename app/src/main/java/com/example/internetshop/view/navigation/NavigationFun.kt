package com.example.internetshop.view.navigation

import androidx.navigation.NavController

class NavigationFun {
    fun GoToNextScreen(navController: NavController, whereFrom: String, where: String) {
        navController.navigate(where) {
            popUpTo(whereFrom) {
                inclusive = true
            }
        }
    }
}