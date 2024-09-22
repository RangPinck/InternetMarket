package com.example.internetshop.view.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.internetshop.view.commonparts.bars.bottombar.BoottomBar
import com.example.internetshop.view.commonparts.bars.topbar.TopBar
import com.example.internetshop.view.commonparts.buttons.BlueButton
import com.example.internetshop.view.commonparts.textfields.MainTextField
import com.example.internetshop.view.commonparts.texts.BigEBoldKanitSeaColorText
import com.example.internetshop.view.signup.components.MessageOfEmailAreNotEqales
import com.example.internetshop.view.signup.components.MessageOfErrorPasswordEquality
import com.example.internetshop.view.signup.components.createCheckbox

@Composable
fun SignUp(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val passwordOne = remember { mutableStateOf("") }
    val passwordTwo = remember { mutableStateOf("") }
    val nickname = remember { mutableStateOf("") }
    val seller = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BoottomBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            BigEBoldKanitSeaColorText("Регистрация");

            Column {
                nickname.value =
                    MainTextField(lable = "Введите имя:", place = "Youre name", isForPass = false)
                Spacer(modifier = Modifier.height(10.dp))
                email.value = MainTextField(
                    lable = "Введите почту:",
                    place = "pochta@pochta.ru",
                    isForPass = false
                )

                MessageOfEmailAreNotEqales(email.value)

                Spacer(modifier = Modifier.height(10.dp))
                passwordOne.value = MainTextField(lable = "Введите пароль:", isForPass = true)
                Spacer(modifier = Modifier.height(10.dp))
                passwordTwo.value = MainTextField(lable = "Повторите пароль:", isForPass = true)
            }

            MessageOfErrorPasswordEquality(passwordOne.value, passwordTwo.value)

            createCheckbox(seller)

            BlueButton(onClick = {
                //
            }, text = "Регистрация")
        }
    }
}