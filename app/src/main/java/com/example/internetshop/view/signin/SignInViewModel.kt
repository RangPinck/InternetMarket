package com.example.internetshop.view.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class SignInViewModel() : ViewModel() {
    fun onSIgInWithEmailAndPassword(
        navController: NavController,
        emailUser: String,
        passwordUser: String
    ) {
        val nav = NavigationFun()
        viewModelScope.launch {
            try {
                val user = Constants.supabase.auth.signInWith(Email) {
                    email = emailUser
                    password = passwordUser
                }

                Log.d("signIn", user.toString())
                Log.d("signIn", Constants.supabase.auth.currentUserOrNull()!!.id)
                Log.d("signIn", "Success")

                nav.GoToNextScreen(
                    navController,
                    Routes.LogIn.route,
                    Routes.Start.route
                )
            } catch (e: Exception) {
                Log.e("signIn", "Error")
                Log.e("signIn", e.message.toString())
            }
        }
    }
}