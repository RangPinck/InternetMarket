package com.example.internetshop.view.market

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.bars.topbar.TopBar
import com.example.internetshop.view.commonparts.buttons.BlueButton

@Composable
fun Market(navController: NavController) {


    Scaffold(
        topBar = { TopBar() },
        bottomBar = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}