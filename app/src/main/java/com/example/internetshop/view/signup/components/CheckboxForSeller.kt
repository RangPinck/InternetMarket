package com.example.internetshop.view.signup.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun createCheckbox(checkSeller: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkSeller.value,
            onCheckedChange = { checkSeller.value = it },
            colors = CheckboxDefaults.colors(
                disabledCheckedColor = MaterialTheme.colorScheme.secondary,
                checkedColor = MaterialTheme.colorScheme.secondary,
                disabledUncheckedColor = MaterialTheme.colorScheme.secondary
            )
        )

        Text(
            text = "Я продавец",
            fontFamily = Kanit,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}