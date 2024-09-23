import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.internetshop.model.User
import com.example.internetshop.view.commonparts.bars.bottombar.BoottomBar
import com.example.internetshop.view.commonparts.bars.topbar.TopBar
import com.example.internetshop.view.commonparts.buttons.BlueButton
import com.example.internetshop.view.commonparts.localuser.CurrentUserData
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.profile.ProfileViewModel
import com.example.internetshop.view.profile.components.AnotherData
import com.example.internetshop.view.profile.components.createProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun Profile(navController: NavController) {
    val us = CurrentUserData()

    val viewModel by remember {
        mutableStateOf(
            ProfileViewModel()
        )
    }

    val countPr by viewModel.countPr.collectAsState(initial = 0)

    var user by remember {
        mutableStateOf(
            User(
                id = "11111111111111",
                Name = "User",
                Email = "user@user.com",
                ProfileImage = null,
                Role = 2
            )
        )
    }

    viewModel.getCountProducts()

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try{
                user = us.GetDataCurrantUerOnNUll()!!
            }catch (e : Exception){
                Log.e("Profile", "Dont get data about currant user")
            }
        }
    }

    Scaffold(topBar = {
        TopBar()
    }, bottomBar = {
        BoottomBar(navController)
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            createProfile(
                name = user.Name,
                login = user.Email,
                role = when {
                    UserSpecificData.Role.value == 1 -> "Продавец"
                    else -> "Покупатель"
                },
                image = user.ProfileImage
            )

            Column(
                modifier = Modifier.width(300.dp), horizontalAlignment = Alignment.Start
            ) {
                AnotherData(viewModel.getRegistrationData(), "Зарегистрирован: ")
                Spacer(modifier = Modifier.height(10.dp))
                if (UserSpecificData.Role.value == 1) {
                    AnotherData(
                        text = when {
                            countPr == null -> "0 штук"
                            else -> countPr!!.toString() + " штук"
                        }, "Товаров выложил: "
                    )
                }
            }

            Column {
                BlueButton(
                    onClick = {
                        viewModel.GoToChangeData(navController)
                    },
                    text = "Изменить данные\nаккаункта"
                )
                Spacer(modifier = Modifier.height(20.dp))
                BlueButton(
                    onClick = {
                        viewModel.SignOut(navController)
                    },
                    text = "Выйти из профиля",
                    invert = true
                )
            }
        }
    }
}

