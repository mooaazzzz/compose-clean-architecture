package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun BackgroundImage(
    modifier: Modifier = Modifier,
    image: Int
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = modifier,
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(
            Color.Black.copy(0.5f),
            blendMode = BlendMode.Darken
        )
    )
}