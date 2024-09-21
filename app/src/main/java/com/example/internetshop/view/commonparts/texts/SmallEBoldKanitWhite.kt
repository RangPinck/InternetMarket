package com.example.internetshop.view.commonparts.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun TextForBorder(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = Kanit,
        lineHeight = 1.em,
        softWrap = true,
        textAlign = TextAlign.Center
    )
}