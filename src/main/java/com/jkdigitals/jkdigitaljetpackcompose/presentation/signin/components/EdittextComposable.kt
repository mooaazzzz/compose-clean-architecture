package com.jkdigitals.jkdigitaljetpackcompose.presentation.signin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jkdigitals.jkdigitaljetpackcompose.R

@Composable
fun Edittext(
    modifier: Modifier = Modifier,
    text: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .defaultMinSize(),
            text = text,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.anebaneue_bold)),
            color = Color.White
        )
        Spacer(
            modifier = Modifier
                .height(7.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.b181818), RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
        )

    }
}