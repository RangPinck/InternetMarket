package com.example.internetshop.view.navigation

sealed class Routes(val route: String){
    object Start: Routes("start")
    object LogIn: Routes("login")
    object Registration: Routes("regisration")
    object Market: Routes("market")
    object Profile: Routes("profile")
    object SellerPanel: Routes("sellerpanel")
    object ChangeProfile: Routes("changeprofile")
    object CreateProduct: Routes("createproduct")
}