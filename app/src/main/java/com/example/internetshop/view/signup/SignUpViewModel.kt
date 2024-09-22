package com.example.internetshop.view.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.User
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class SignUpViewModel() : ViewModel() {
    val nav = NavigationFun()

    fun SifnUpWithEmail(
        emailUser: String,
        passwordUser: String,
        name: String,
        isSeller: Boolean,
        navController: NavController
    ) {
        viewModelScope.launch {

            var resp = SignUpToAuthWithEmail(
                emailUser = emailUser, passwordUser = passwordUser
            )

            if (resp) {
                resp = InserNewUser(
                    emailUser = emailUser, name = name, isSeller = isSeller
                )

                if (resp) {
                    nav.GoToNextScreen(navController, Routes.Registration.route, Routes.Start.route)
                }
            } else {
                Log.e("signUp", "Error")
                Log.e("signUp", "user dont registration")
            }
        }
    }

    suspend fun SignUpToAuthWithEmail(
        emailUser: String,
        passwordUser: String,
    ): Boolean {
        return try {
            val response = Constants.supabase.auth.signUpWith(Email) {
                email = emailUser
                password = passwordUser
            }
            true
        } catch (e: Exception) {
            Log.e("signUp", "Error")
            Log.e("signUp", e.message.toString())
            false
        }
    }

    suspend fun InserNewUser(
        emailUser: String, name: String, isSeller: Boolean
    ): Boolean {
        val curUser = Constants.supabase.auth.currentUserOrNull()

        return if (Constants.supabase.auth.currentUserOrNull() != null) {
            return try {
                val insertUser = User(
                    id = curUser!!.id,
                    Name = name,
                    ProfileImage = null,
                    Email = emailUser,
                    Role = when {
                        isSeller -> 1
                        else -> 2
                    }
                )

                Log.e("signUp", insertUser.toString())
                Log.e("signUp", "Success")

                Constants.supabase.from("User").insert(insertUser)

                Log.e("signUp", "insert done")
                Log.e("signUp", "Success")

                true
            } catch (e: Exception) {
                Log.e("signUp", "Error")
                Log.e("signUp", e.message.toString())
                false
            }
        } else {
//            Log.e("signUp", "Error")
//            Log.e("signUp", "user dont registration")
            false
        }
    }
}