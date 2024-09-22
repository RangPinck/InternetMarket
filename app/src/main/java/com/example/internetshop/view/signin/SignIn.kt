package com.example.internetshop.view.signin

import com.example.internetshop.view.signin.components.CreateLinktoRegistraion
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
import com.example.internetshop.view.navigation.NavigationFun
import com.example.internetshop.view.navigation.Routes
import com.example.internetshop.view.signin.SignInViewModel

@Composable
fun SignIn(navController: NavController) {
    val viewModel = SignInViewModel()
    val nav = NavigationFun()
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

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
            BigEBoldKanitSeaColorText(
                "Войдите в свой\n" +
                        "аккаунт"
            )

            Column {
                email.value = MainTextField(
                    lable = "Введите почту:",
                    isForPass = false,
                    place = "pochta@pochta.ru"
                )
                Spacer(modifier = Modifier.height(15.dp))
                password.value = MainTextField(lable = "Введите пароль:", isForPass = true)
            }

            BlueButton({
                viewModel.onSIgInWithEmailAndPassword(
                    navController = navController,
                    emailUser = email.value,
                    passwordUser = password.value,
                )
            }, "Войти")

            CreateLinktoRegistraion(
                onClick =
                {
                    nav.GoToNextScreen(
                        navController,
                        Routes.LogIn.route,
                        Routes.Registration.route
                    )
                })
        }
    }
}