package com.example.internetshop.view.sellerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.internetshop.model.Products
import com.example.internetshop.view.commonparts.buttons.BlueButton
import com.example.internetshop.view.commonparts.images.ProductImageNone
import com.example.internetshop.view.sellerpanel.SellerPanelViewModel

@Composable
fun SellerPanelItem(product: Products, navController: NavController) {
    val view = SellerPanelViewModel()

    Column(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .padding(horizontal = 5.dp, vertical = 3.dp)
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (product.Image.isNullOrEmpty()) {
                ProductImageNone(120)
            } else {
                val imageState = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.Image).size(Size.ORIGINAL).build()
                ).state

                if (imageState is AsyncImagePainter.State.Error) {
                    ProductImageNone(170)
                } else {
                    if (imageState is AsyncImagePainter.State.Error) {
                        ProductImageNone(170)
                    }
                    if (imageState is AsyncImagePainter.State.Success) {
                        Image(
                            modifier = Modifier
                                .size(170.dp)
                                .clip(RoundedCornerShape(10))
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(10)
                                ),
                            painter = imageState.painter,
                            contentDescription = "",
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RowWithLine("Серийный номер:", product.id.toString())
                RowWithLine("Название:", product.ProdcutName)
                RowWithLine("Цена:", product.Salary.toString())
            }
        }

        BlueButton(onClick = { view.deletePRoduct(product.id, navController) }, text = "Удалить", invert = true)
    }
}