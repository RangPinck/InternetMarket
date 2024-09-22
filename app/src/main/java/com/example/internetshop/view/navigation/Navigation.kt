package com.example.internetshop.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internetshop.view.market.Market
import com.example.internetshop.view.market.MarketViewModel
import com.example.internetshop.view.signin.SignIn
import com.example.internetshop.view.startscreen.StartScreen
import io.github.jan.supabase.gotrue.SessionSource

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Start.route) {
        composable(Routes.Start.route) { StartScreen(navController) }
        composable(Routes.Market.route) { Market(navController) }
        composable(Routes.LogIn.route) { SignIn(navController) }
        composable(Routes.Registration.route) { }//SignUp(navController) }
        composable(Routes.Profile.route) { }//Profile(navController) }
        composable(Routes.ChangeProfile.route) { }//ChangeData(navController) }
        composable(Routes.SellerPanel.route) { }//SellerPanel(navController) }
    }
}