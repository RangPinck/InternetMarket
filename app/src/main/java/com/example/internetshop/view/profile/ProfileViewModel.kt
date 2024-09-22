package com.example.internetshop.view.profile

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.Products
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class ProfileViewModel() : ViewModel() {
    val nav = NavigationFun()

    private var _countPr = MutableStateFlow<Long?>(0)

    val countPr = _countPr.asStateFlow()

    fun SignOut(navController: NavController) {
        viewModelScope.launch {
            Constants.supabase.auth.signOut()
            nav.GoToNextScreen(navController, Routes.Profile.route, Routes.Start.route)
        }
    }

    fun GoToChangeData(navController: NavController) {
        nav.GoToNextScreen(navController, Routes.Profile.route, Routes.ChangeProfile.route)
    }

    fun getRegistrationData(): String {
        val data = mutableStateOf("")
        try {
            data.value = Constants.supabase.auth.currentUserOrNull()!!.createdAt?.toLocalDateTime(
                TimeZone.UTC
            )?.date.toString()
        } catch (e: Exception) {
            Log.e("Profile", "Error")
            Log.e("Profile", e.message.toString())
        }

        return data.value
    }

    fun getCountProducts() {
        val pr = mutableStateOf<List<Products>>(listOf())

        viewModelScope.launch {
            try {
                pr.value = Constants.supabase.from("Products")
                    .select() {
                        filter {
                            eq("Seller", UserSpecificData.id.value)
                        }
                    }.decodeAs<List<Products>>()

                _countPr.value = pr.value.size.toLong()
                //Log.e("Profile", pr.toString())
            } catch (e: Exception) {
                Log.e("Profile", "Error")
                Log.e("Profile", e.message.toString())
            }
        }
    }

}