package com.example.internetshop.view.startscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import com.example.internetshop.view.startscreen.components.DelayBeforeSwitch
import com.example.internetshop.view.startscreen.components.StartText

@Composable
fun StartScreen(navController : NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.primary
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StartText()
        DelayBeforeSwitch(navController)
    }
}