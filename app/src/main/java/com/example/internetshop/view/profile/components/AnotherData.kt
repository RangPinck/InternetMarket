package com.example.internetshop.view.profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.internetshop.view.commonparts.texts.SmallNormalKanitOnBGText
import com.example.internetshop.view.commonparts.texts.SmallNornalKanitBlueText

@Composable
fun AnotherData(text: String, name: String) {
    Row {
        SmallNormalKanitOnBGText(text = name, align = TextAlign.Left)
        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp))
        SmallNornalKanitBlueText(text = text, align = TextAlign.Left)
    }
}