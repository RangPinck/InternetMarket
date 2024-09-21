package com.example.internetshop.view.startscreen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kavoon

@Composable
fun StartText() {
    Text(
        text = "Internet\nMarket",
        fontFamily = Kavoon,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        lineHeight = 1.em
    )
}