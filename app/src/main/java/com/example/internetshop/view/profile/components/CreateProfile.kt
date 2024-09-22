package com.example.internetshop.view.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.internetshop.view.commonparts.images.ProductImageNone
import com.example.internetshop.view.commonparts.images.UserImageNone
import com.example.internetshop.view.commonparts.texts.BigEBoldKanitOnBGText
import com.example.internetshop.view.commonparts.texts.BigEBoldKanitSeaColorText

@Composable
fun createProfile(
    role: String, name: String, login: String, image: String? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BigEBoldKanitSeaColorText("Профиль")
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.width(300.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            if (image.isNullOrEmpty()) {
                UserImageNone()
            } else {
                val imageState = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current).data(image)
                        .size(Size.ORIGINAL).build()
                ).state

                if (imageState is AsyncImagePainter.State.Error) {
                    UserImageNone()
                } else {
                    if (imageState is AsyncImagePainter.State.Error) {
                        UserImageNone()
                    }
                    if (imageState is AsyncImagePainter.State.Success) {
                        Image(
                            modifier = Modifier
                                .size(width = 140.dp, height = 200.dp)
                                .clip(RoundedCornerShape(10))
                                .border(
                                    width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10)
                                ),
                            painter = imageState.painter,
                            contentDescription = "",
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                BigEBoldKanitOnBGText(role)
                Spacer(modifier = Modifier.height(20.dp))
                spaceWithRow(name, "Имя/ник")
                Spacer(modifier = Modifier.height(10.dp))
                spaceWithRow(login, "Почта")
            }
        }
    }
}