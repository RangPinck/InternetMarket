package com.example.internetshop.view.commonparts.bars.bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.internetshop.model.ButtoonBarNavigationItem
import com.example.internetshop.model.User
import com.example.internetshop.view.commonparts.bars.bottombar.components.BarForSeller
import com.example.internetshop.view.commonparts.bars.bottombar.components.BarForUncownUser
import com.example.internetshop.view.commonparts.bars.bottombar.components.BarForUser
import com.example.internetshop.view.commonparts.localuser.UserSpecificData
import com.example.internetshop.view.navigation.Routes

@Composable
fun BoottomBar(navController: NavController) {
    var state = false

    var barList = remember {
        mutableStateOf<List<ButtoonBarNavigationItem>>(listOf())
    }

    val whereFrom = navController.currentBackStackEntry?.destination?.route

    barList.value = when {
        //бар для продовца
        UserSpecificData.Role.value == 1 -> BarForSeller()
        //бар для пользователя
        UserSpecificData.Role.value == 2 -> BarForUncownUser()
        //бар с логином
        else -> BarForUser()
    }


    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15, 15, 0, 0))
    ) {
        barList.value.forEachIndexed { index, item ->

            state = when {
                whereFrom == item.route -> true
                item.route == Routes.Profile.route && (whereFrom == Routes.LogIn.route || whereFrom == Routes.Registration.route) -> true
                else -> false
            }

            NavigationBarItem(
                selected = false,
                onClick = {

                },
                icon = {
                    Image(
                        imageVector = ImageVector.vectorResource(item.selectedIcon),
                        contentDescription = item.route,
                        colorFilter = ColorFilter.tint(
                            color = when {
                                state -> Color.White
                                else -> MaterialTheme.colorScheme.secondary
                            }
                        ),
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        }
    }
}