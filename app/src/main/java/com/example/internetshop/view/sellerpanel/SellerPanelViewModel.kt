package com.example.internetshop.view.sellerpanel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.Products
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SellerPanelViewModel() : ViewModel() {
    private var _products = MutableStateFlow<List<Products>>(
        listOf()
    )
    val products = _products.asStateFlow()

    fun getProductsCurrentUser() {
        viewModelScope.launch {
            try {
                _products.value =
                    Constants.supabase.from("Products").select(){
                        filter {
                            eq("Seller", UserSpecificData.id.value)
                        }
                    }.decodeList<Products>()

                _products.value.forEach { it -> Log.e("market", it.ProdcutName) }

            } catch (e: Exception) {
                Log.e("market", "Error")
                Log.e("market", e.message.toString())
            }
        }
    }

    fun deletePRoduct(productId: Int, navController: NavController){
        val nav = NavigationFun()

        viewModelScope.launch {
            try {
                    Constants.supabase.from("Products").delete(){
                        filter {
                            eq("id", productId)
                        }
                    }
                Log.e("market", "product was delete")
            } catch (e: Exception) {
                Log.e("market", "Error")
                Log.e("market", e.message.toString())
            }
        }

        nav.GoToNextScreen(navController, Routes.SellerPanel.route,  Routes.SellerPanel.route)
    }
}