package com.example.internetshop.view.sellerpanel.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.internetshop.view.commonparts.canvas.CreateCanvasLine
import com.example.internetshop.view.commonparts.texts.SmallEBoldKaintOnBGText
import com.example.internetshop.view.commonparts.texts.SmallNormalKanitOnBGText

@Composable
fun RowWithLine(head: String, text: String) {
    SmallNormalKanitOnBGText(text = head, align = TextAlign.Left)
    SmallEBoldKaintOnBGText(text = text)
    CreateCanvasLine(withContainer = 200, startLine = 0f, endLine =500f )
    Spacer(modifier = Modifier.height(10.dp))
}