package com.example.internetshop.view.commonparts.textfields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.internetshop.R
import com.example.internetshop.view.commonparts.texts.SmallNornalKanitBlueText
import com.example.internetshop.view.ui.theme.Kanit

@Composable
fun MainTextField(lable: String, isForPass: Boolean = false, place: String = ""): String {

    val passwordVis = remember {
        mutableStateOf(false)
    }

    val userData = remember {
        mutableStateOf("")
    }

    Column {

        SmallNornalKanitBlueText(text = lable)

        OutlinedTextField(
            value = userData.value,
            onValueChange = { newText -> userData.value = newText },
            textStyle = CurrentTextStyle(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            placeholder = {
                when {
                    isForPass && passwordVis.value -> SmallNornalKanitBlueText(
                        text = "password123",
                        alpha = 0.5f
                    )

                    isForPass && !passwordVis.value -> SmallNornalKanitBlueText(
                        text = "***********",
                        alpha = 0.5f
                    )

                    else -> SmallNornalKanitBlueText(
                        text = place,
                        alpha = 0.5f
                    )
                }
            },
            singleLine = true,
            modifier = Modifier
                .width(300.dp)
                .border(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(15.dp)
                )
                .clip(RoundedCornerShape(15.dp)),
            visualTransformation = when {
                isForPass && passwordVis.value -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            trailingIcon = {
                if (isForPass) {
                    IconButton(onClick = { passwordVis.value = !passwordVis.value }) {
                        if (passwordVis.value) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.openyey),
                                contentDescription = "open yey",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier
                                    .size(25.dp)
                            )
                        } else {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.closeyey),
                                contentDescription = "open yey",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier
                                    .size(25.dp)
                            )
                        }
                    }
                }
            }
        )
    }

    return userData.value
}

@Composable
fun CurrentTextStyle(): TextStyle {
    val textFormat = TextStyle(
        fontFamily = Kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 1.em
    )
    return textFormat
}