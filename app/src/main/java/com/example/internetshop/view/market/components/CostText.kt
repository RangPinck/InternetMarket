package com.example.internetshop.view.market.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun showCosts(cost: Double) {
    Text(
        text = String.format("%.2f", cost) + " p.",
        softWrap = true,
        fontFamily = Kanit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(0.dp, 10.dp)
    )
}