package com.example.internetshop.view.commonparts.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.commonparts.texts.TextForBorder
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun BlueButton(onClick: () -> Unit, text: String, invert: Boolean = false) {

    val buttomSize = when {
        text.length > 20 -> 65
        else -> 55
    }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = when {
                invert -> Color(0xFFEE703B)
                else -> MaterialTheme.colorScheme.primary
            }

        ),
        modifier = Modifier
            .size(300.dp, buttomSize.dp)
            .border(
                width = 3.dp,
                color = when {
                    invert -> Color(0xFFFB3125)
                    else -> MaterialTheme.colorScheme.secondary
                },
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
    ) {
        TextForBorder(text)
    }
}