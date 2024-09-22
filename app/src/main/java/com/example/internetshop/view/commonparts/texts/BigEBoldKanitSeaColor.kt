package com.example.internetshop.view.commonparts.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun BigEBoldKanitSeaColorText(text: String) {
    Text(
        text = text,
        fontFamily = Kanit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.secondary
    )
}
