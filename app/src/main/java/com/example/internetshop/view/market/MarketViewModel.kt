package com.example.internetshop.view.market

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.Products
import com.example.internetshop.model.User
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MarketViewModel() : ViewModel() {
    private var _products = MutableStateFlow<List<Products>>(
        listOf()
    )

    private val _users = MutableStateFlow<List<User>>(
        listOf()
    )

    val products = _products.asStateFlow()
    val users = _users.asStateFlow()

    fun getProducts() {
        viewModelScope.launch {
            try {
                _products.value =
                    Constants.supabase.from("Products").select().decodeList<Products>()

                //_products.value.forEach { it -> Log.e("market", it.Seller) }

            } catch (e: Exception) {
                Log.e("market", "Error")
                Log.e("market", e.message.toString())
            }
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                _users.value = Constants.supabase.from("User").select().decodeList<User>()

                //_users.value.forEach { it -> Log.e("market", it.Name) }

            } catch (e: Exception) {
                Log.e("market", "Error")
                Log.e("market", e.message.toString())
            }
        }
    }
}