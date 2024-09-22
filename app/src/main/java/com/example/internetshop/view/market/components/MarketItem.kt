package com.example.internetshop.view.market.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.internetshop.view.commonparts.images.ProductImageNone
import com.example.internetshop.view.commonparts.texts.SmallEBoldKaintOnBGText
import com.example.internetshop.view.commonparts.texts.SmallNormalKanitOnBGText

@Composable
fun MarketItem(
    image: String? = "",
    name: String,
    seller: String,
    cost: Double
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(120.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(10))
            .padding(horizontal = 5.dp, vertical = 3.dp)
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10))
    ) {
        if (image.isNullOrEmpty()) {
            ProductImageNone(120)
        } else {
            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image).size(Size.ORIGINAL).build()
            ).state

            if (imageState is AsyncImagePainter.State.Error) {
                ProductImageNone(120)
            } else {
                if (imageState is AsyncImagePainter.State.Error) {
                    ProductImageNone(120)
                }
                if (imageState is AsyncImagePainter.State.Success) {
                    Image(
                        modifier = Modifier
                            .size(120.dp)
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
        SmallEBoldKaintOnBGText(name)
        SmallNormalKanitOnBGText(seller, TextAlign.Center)
        showCosts(cost)
    }
}