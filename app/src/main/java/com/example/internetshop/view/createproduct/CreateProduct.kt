package com.example.internetshop.view.createproduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun CreateProduct(navController: NavController) {
    val viewModel = CreateProductViewModel()

    val productName = remember {
        mutableStateOf(
            ""
        )
    }
    val salary = remember {
        mutableStateOf(
            0.0
        )
    }

    val salaryString = remember {
        mutableStateOf(
            ""
        )
    }

    Scaffold(topBar = { TopBar() },
        bottomBar = { BoottomBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            BigEBoldKanitSeaColorText(text = "Создание карточки\nтовара")

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                productName.value =
                    MainTextField(lable = "Введите название товара:", place = "Product name")
                Spacer(modifier = Modifier.height(15.dp))
                salaryString.value =
                    MainTextField(
                        lable = "Введите цену товара:",
                        place = "Salary product"
                    )
            }

            salary.value = viewModel.ConvertStringToDouble(salaryString.value)

            BlueButton(
                onClick = {
                    viewModel.CreateProduct(
                        productName = productName.value,
                        salary = salary.value,
                        navController = navController
                    )
                },
                text = "Создать товар",
                isEnable = !(productName.value.isNullOrEmpty() || salary.value < 0.0)
            )
        }
    }
}