package com.example.internetshop.view.signup.components

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
import com.example.internetshop.view.signup.SignUpViewModel
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun MessageOfErrorPasswordEquality(pswdOne: String, pswdTwo: String) : Boolean {
    val str = remember {
        mutableStateOf("")
    }

    var result = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = pswdTwo) {
        str.value = when {
            pswdOne == pswdTwo -> ""
            else -> "Разные пароли!"
        }

        result.value = (!pswdOne.isNullOrEmpty() && !pswdTwo.isNullOrEmpty() && pswdOne == pswdTwo)
    }

    Text(
        text = str.value,
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color(0xFFFB3125),
        textAlign = TextAlign.Center
    )

    return result.value
}

@Composable
fun MessageOfEmailAreNotEqales(flagExistEmail: Boolean) {
    val str = remember {
        mutableStateOf("")
    }

    str.value = when {
        flagExistEmail -> ""
        else -> "Почта уже существует!"
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