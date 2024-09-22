package com.example.internetshop.view.commonparts.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.internetshop.view.commonparts.texts.SmallEBoldKanitWhiteText


@Composable
fun BlueButton(onClick: () -> Unit, text: String, invert: Boolean = false, isEnable: Boolean = true) {

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
        enabled = isEnable,
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
        SmallEBoldKanitWhiteText(text)
    }
}