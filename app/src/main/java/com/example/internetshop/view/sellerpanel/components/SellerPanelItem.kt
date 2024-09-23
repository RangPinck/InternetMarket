package com.example.internetshop.view.sellerpanel.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.internetshop.model.Products

@Composable
fun SellerPAnelItem(product: Products) {
    Row(
        modifier = Modifier
            .height(170.dp)
            .clip(RoundedCornerShape(10))
            .padding(horizontal = 5.dp, vertical = 3.dp)
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10)),

    ) {

    }
}