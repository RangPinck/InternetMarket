package com.example.internetshop.view.commonparts.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.internetshop.R

@Composable
fun UserImageNone() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.Gray, shape = RoundedCornerShape(10))
            .size(width = 140.dp, height = 200.dp)
            .clip(RoundedCornerShape(10))
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.man),
            contentDescription = "standart user image",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(10))
        )
    }
}