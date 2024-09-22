package com.example.internetshop.view.commonparts.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CreateCanvasLine(withContainer: Int, startLine: Float, endLine: Float) {
    Canvas(
        modifier = Modifier
            .width(withContainer.dp),
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(x= startLine, y = 0f),
            end = Offset(x = endLine, y = 0f),
            strokeWidth = 5f
        )
    }
}