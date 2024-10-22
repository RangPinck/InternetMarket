package com.example.internetshop.view.commonparts.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun SmallNormalKanitOnBGText(text: String, align: TextAlign) {
    Text(
        text = text,
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = align
    )
}