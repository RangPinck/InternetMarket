package com.example.internetshop.view.commonparts.bars.bottombar.components

import com.example.internetshop.R
import com.example.internetshop.model.ButtoonBarNavigationItem
import com.example.internetshop.view.navigation.Routes

fun BarForSeller(): List<ButtoonBarNavigationItem> {
    val items = listOf(
        ButtoonBarNavigationItem(
            selectedIcon = R.drawable.stall,
            route = Routes.Market.route
        ),
        ButtoonBarNavigationItem(
            selectedIcon = R.drawable.box,
            route = Routes.SellerPanel.route
        ),
        ButtoonBarNavigationItem(
            selectedIcon = R.drawable.plusnav,
            route = Routes.CreateProduct.route
        ),
        ButtoonBarNavigationItem(
            selectedIcon = R.drawable.man,
            route = Routes.Profile.route
        ),
    )

    return items
}