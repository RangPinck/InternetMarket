package com.example.internetshop.view.market

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.bars.bottombar.BoottomBar
import com.example.internetshop.view.commonparts.bars.topbar.TopBar
import com.example.internetshop.view.market.components.MarketItem

@Composable
fun Market(navController: NavController) {
    val viewModel by remember {
        mutableStateOf(
            MarketViewModel()
        )
    }
    val products by viewModel.products.collectAsState(initial = emptyList())
    val users by viewModel.users.collectAsState(initial = emptyList())

    viewModel.getProducts()
    viewModel.getUsers()

//    users.forEach { it -> Log.e("market", it.Name) }
//    products.forEach { it -> Log.e("market", it.ProdcutName) }

    if (users.size != 0 && products.size != 0) {
        Scaffold(topBar = { TopBar() },
            bottomBar = { BoottomBar(navController) }) { paddingValues ->

            LazyVerticalGrid(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
                contentPadding = PaddingValues(10.dp),
                columns = GridCells.Fixed(3),
                content = {
                    items(products, key = { product -> product.id }) { product ->
                        MarketItem(
                            image = product.Image,
                            name = product.ProdcutName,
                            seller = users.first { x -> x.id == product.Seller }.Name,
                            cost = product.Salary
                        )
                    }
                })
        }
    }
}