package com.example.internetshop.view.sellerpanel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.bars.bottombar.BoottomBar
import com.example.internetshop.view.commonparts.bars.topbar.TopBar


@Composable
fun SellerPanel(navController: NavController) {
    val viewModel by remember {
        mutableStateOf(
            SellerPanelViewModel()
        )
    }
    val products by viewModel.products.collectAsState(initial = emptyList())

    viewModel.getProductsCurrentUser()

    Scaffold(topBar = { TopBar() }, bottomBar = { BoottomBar(navController) }) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

        }
    }
}