package com.example.internetshop.view.createproduct

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internetshop.domain.utils.Constants
import com.example.internetshop.model.Products
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.navigation.Navigation
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class CreateProductViewModel() : ViewModel() {
    fun ConvertStringToDouble(str: String): Double {
        val result = mutableStateOf(-1.0)
        if (!str.isNullOrEmpty()) {
            try {
                result.value = str.toDouble()
            } catch (e: Exception) {
                Log.e("Create product", "Не удалось конвертировать")
            }
        }

        return result.value
    }

    fun CreateProduct(productName: String, salary: Double, navController: NavController) {
        val nav = NavigationFun()

        viewModelScope.launch {
            try {
                Constants.supabase.from("Products").insert(
                    Products(
                        id = (getCoutnProduct() + 1),
                        ProdcutName = productName,
                        Salary = salary,
                        Seller = UserSpecificData.id.value,
                        Image = null
                    )
                )

                nav.GoToNextScreen(
                    navController,
                    Routes.CreateProduct.route,
                    Routes.SellerPanel.route
                )
            } catch (e: Exception) {
                Log.e("Create product", "Error")
                Log.e("Create product", e.message.toString())
            }
        }
    }



    suspend fun getCoutnProduct(): Int{
        val pr = mutableStateOf<List<Products>>(listOf())
        try {
        pr.value = Constants.supabase.from("Products")
            .select().decodeAs<List<Products>>()
        } catch (e: Exception) {
            Log.e("Create product", "Error")
            Log.e("Create product", e.message.toString())
        }
        return pr.value.last().id
    }
}