package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jkdigitals.jkdigitaljetpackcompose.R

@Composable
fun AppStandardButton(onClick: () -> Unit, text: String) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.gradient_0),
            colorResource(id = R.color.gradient_25),
            colorResource(id = R.color.gradient_50),
            colorResource(id = R.color.gradient_75),
            colorResource(id = R.color.gradient_100),
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .height(50.dp)
            .background(brush = gradient, shape = RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.gradient_0),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = buttonColors(containerColor = Color.Transparent), // Make button background transparent
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text(
                text = text,
                color = colorResource(id = R.color.white),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.anebaneue_bold))
            )
        }
    }
}
