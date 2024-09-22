package com.example.internetshop.view.signup.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun MessageOfErrorPasswordEquality(pswdOne: String, pswdTwo: String) {
    val str = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = pswdTwo) {
        str.value = when{
            pswdOne == pswdTwo -> ""
            else -> "Разные пароли!"
        }
    }

    Text(
        text = str.value,
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color(0xFFFB3125),
        textAlign = TextAlign.Center
    )

}

@Composable
fun MessageOfEmailAreNotEqales(email: String) {
    val str = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = email) {
        str.value = when{
            true -> ""
            else -> "Разные пароли!"
        }
    }
    Text(
        text = str.value,
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color(0xFFFB3125),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 5.dp)
    )

}