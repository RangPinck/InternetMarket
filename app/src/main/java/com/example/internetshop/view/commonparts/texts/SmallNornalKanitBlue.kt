package com.example.internetshop.view.commonparts.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun SmallNornalKanitBlueText(text: String, align: TextAlign = TextAlign.Left, alpha: Float = 1f) {
    Text(
        text = text,
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.primary.copy(alpha = alpha),
        textAlign = align,
    )
}