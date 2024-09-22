package com.example.internetshop.view.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.internetshop.view.commonparts.canvas.CreateCanvasLine
import com.example.internetshop.view.commonparts.texts.SmallNormalKanitOnBGText
import com.example.internetshop.view.commonparts.texts.SmallNornalKanitBlueText

@Composable
fun spaceWithRow(text: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SmallNornalKanitBlueText(text = text, align = TextAlign.Center)
        CreateCanvasLine(withContainer = 130, startLine = 0f, endLine = 350f)
        SmallNormalKanitOnBGText(text = name, align = TextAlign.Center)
    }
}